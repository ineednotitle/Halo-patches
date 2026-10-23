# Performance Analysis — doom-reddit-patches

**Date:** 2026-10-23 · **Scope:** injected runtime (smali stubs + extension helper), patch-time cost in Morphe Manager, measurable app-side wins · **Commit audited:** `5f1f8b8` (v1.2.5→)

---

## 1. Executive summary

The patch set is architecturally cheap: everything injected is constant-sized bytecode or an `O(visible-list)` pass with a reflection cache. The **single defect found is a latent crash in the feed filter's cache** (`ConcurrentHashMap` cannot store `null`; classes without a "promoted" getter would throw `NullPointerException` in the render path, and re-throw two reflection exceptions on every frame thereafter). Fixed in this commit. All other findings are micro-level or wins.

## 2. Runtime cost per injected patch

| Patch | What executes per frame / event | Cost class | Notes |
|---|---|---|---|
| Unlock Premium | 3 × `const/16 vR, 0x1` writes, once per Account JSON parse (app start / auth refresh / rarely) | nanoseconds | Constant-time boolean forced at the data-source — zero per-frame cost. |
| Disable Click Tracking | 1 write per Account parse | nanoseconds | Same. |
| Unlock Account Entitlements | ≤4 writes per Account parse | nanoseconds | Same. |
| Employee Debug Flags | 1 write per Account parse | nanoseconds | Same. |
| Remove ads — Listing filter | `invoke-static` + one `hideOldPostAds(list)` pass per Listing construction (per feed page) | **O(page size)** — see §3 | Reflection cached per class after first hit. |
| Remove ads — comment layers | A static gate call per comment-thread ad-load; one OR'd boolean per state construction | nanoseconds | Both layers are no-op/degenerate fast paths. |
| Remove ads — AdPostSection kill | `return-void` replaces a ~1600-line composable + its impression callbacks | **strictly negative cost (a win)** | Skips render, layout, measure, click analytics, impression sinks, and the ad's network telemetry batch (biggest app-side perf *gain* of the whole pack). |

## 3. The feed filter (`RedditFeedHelper`) — full review

### What it does per feed page
1. `hideOldPostAds(list)`: indexed scan, no iterator allocation; copies only when an ad is present (`copy-on-first-ad` → zero allocations in the common empty case).
2. Per item: cached class→`Method` lookup (`ConcurrentHashMap` hit after warm-up), one reflective `invoke`, `Boolean.TRUE.equals` (no autoboxing).

**Per-frame budget estimate** on a 60-item page: ~60 map hits × ~50ns + ≤60 reflective invokes × ~0.3–1µs → **~0.02–0.06 ms** worst case. ART-cheap.

### Defect found (fixed in this commit)
```java
Map<Class<?>, Method> cache = new ConcurrentHashMap<>();   // CANNOT hold null values
...
getter = findPromotedGetter(cls);          // null for classes without a promoted flag
cache.put(cls, getter);                    // NullPointerException on put(cls, null)
```
`isPromoted` documents intent ("may store null: no promoted flag") but `ConcurrentHashMap.put(K, null)` throws `NullPointerException`. Reachable today only if a Listing contains a non-ILink row class (adapter headers, spacers), but after any Reddit model drift the render path would:
1. throw `NoSuchMethodException` ×2 inside `findPromotedGetter` (each with stack-fill overhead ~10µs),
2. then throw `NullPointerException` uncaught across the feed construction chain.

**Fix** (`v1.2.5`): cache storage is `Optional<Method>`; names array hoisted to a constant; the warmed path has **zero exception activity** for all row classes, including non-ILink ones:
- per-class resolution happens once (`computeIfAbsent`),
- no exceptions thrown after warm-up,
- non-ILink rows correctly evaluate as "never promoted".

### Acknowledged (intentional fast paths)
- `hideNewPostAds` always returns null — the upstream sections-list layer is *superseded* by the AdPostSection composable kill (its input class cannot even be created as a List on 2026.42.0). Kept for backward-compatibility of the injection contract; zero runtime cost since that injection site is no longer added.
- `hideCommentAds(...)` is a documented force-true, OR'd with the original value for graceful degradation.

## 4. Patch-time cost in Morphe Manager (per patch run)

| Contributor | Cost | Notes |
|---|---|---|
| Class-pool (un)dexing of 11 dex files (~90k classes) | dominated by patcher framework | Not our code. |
| Our fingerprints (8 in Remove ads + 2 in Premium + shared 3) | full-pool scans each for method matching | String-filtered fingerprints first index by string table → fast pruning; total <1–2s per patch on modern devices. |
| Remove-ads layer 5 (execute-time method enumeration of the resolved AdPostSection class) | O(methods of one class) | trivial. |
| `gradle-error-log` diagnostics path (CI) | not user-facing | — |

No optimization warranted; patching is per-release, not per-day.

## 5. App-side wins delivered by the pack

1. **AdPostSection render no-op**: skip ~1600 smali lines of compose layout per sponsored card, plus the unit's impression analytics buffer.
2. **Disable Click Tracking**: removes per-click extras created for outbound links.
3. Listing filter: removes ad payloads from the adapter (fewer bind/measure passes, fewer images fetched for ad cards = memory + network relief).

## 6. Not performance issues (checked and cleared)

- Extension dex (`.mpe`) added to app classpath: single small dex — negligible startup delta.
- `PatchListGenerator`'s `URLClassLoader`: build-time only, never ships inside apps.
- No new threads, sleeves, wake-locks, loopers, broadcast receivers, or handlers introduced anywhere in injected code — zero background energy footprint.
- No allocation-only hot loops outside the (bounded) feed-page filter.

## 7. Changelog

- **v1.2.5** — Fixed `NullPointerException` latent crash in `PROMOTED_GETTER_CACHE`; reflection exceptions after warm-up eliminated; `Optional`-based cache; names array made constant.
