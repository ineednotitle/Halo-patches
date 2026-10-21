# Verification Report — Reddit 2026.42.0

**Target:** `com.reddit.frontpage` 2026.42.0 (versionCode 2642021, uploaded 16 Oct 2026, Android 10+)
**Method (Doom's maintenance loop):** fetch APK → `apktool d` (13 dex, baksmali 2.5.2 for the 6 dex apktool dropped) → grep/inspect every fingerprint anchor → rewrite broken layers → bump `Constants.kt`.

---

## ✅ Remove ads — layer verdicts

| Layer | Anchor | 2026.42.0 status | Action |
|---|---|---|---|
| 1. Feed list filter | `Listing.smali` `<init>` writes `->children`/`->after`/`->before` in order | **UNCHANGED** (smali_classes6) | kept |
| 2. SubmittedListing filter | class itself | **REMOVED upstream** (absent since 2026.16.0, confirmed) | auto-skip via runCatching works as designed |
| (old) AdPostSection sections | `AdPostSection(linkId=` class ctor `p5` = sections `List` | **STALE/BROKEN** — class `com/reddit/ads/impl/feeds/composables/c.smali` now has 13-param ctor; `p5` is an `Lvwp;` model, **not** a `List`. The old injection would VerifyError | **dropped** (documented in Fingerprints.kt) |
| 3. Comment ad-loader kill | `CommentsViewModel` — public final `(Z,L…I)V` + `INVOKE_DIRECT <init>(ZI)V` | **VERIFIED** — exactly one match: `P(ZLcbc;I)V` @line 7346, builds ad loader `La0a;` | kept |
| 4. Comment placeholder force | `CommentsAdState(conversationAdViewState=` + `, adsLoadCompleted=` | **VERIFIED** — class `Lria;`; toString `iget-boolean ->h:Z`; ctor `iput-boolean p8, p0, ->h:Z` — `findFieldAfterString` recovers exactly `->h:Z` | kept |

## ✅ Unlock Premium — rewritten target (data-source surgery)

The earlier toString-based anchor was dropped: Reddit's `Account` toString does **not**
render `isGold=` in this build. New verified choke point:

- `AccountJsonAdapter.fromJson(Lcom/squareup/moshi/e;)Ljava/lang/Object;`
  (smali_classes4), contains all three JSON keys (`is_gold` @2112,
  `has_gold_subscription` @2054, `has_premium_avatar_treatment` @1975).
- Adapter `<init>` builds JsonReader.Options via
  `filled-new-array/range {v2 .. v55}` — 54 keys; indices:
  `is_gold=11`, `has_gold_subscription=12`, `has_premium_avatar_treatment=14`.
- Account `<init>`: 54 params (signature cross-checked against check-cast stream).
- Two construction sites inside fromJson, both patched:
  - full ctor `invoke-direct/range {v8 .. v63}` → computed **v21/v22/v24**
  - marker ctor `invoke-direct/range {v5 .. v63}` → computed **v18/v19/v21**
- Register math (param index → register, wide-type J/D=2) was **machine-simulated
  against the real signature and matches the hand-traced dump registers exactly**.

The patch parses the options table and constructor signature at patch time, so
property reordering in future Reddit builds is absorbed automatically; only the
removal of the adapter/JSON keys themselves will break it (loud PatchException
with re-verify command, never a silent mis-patch).

## 📦 Version matrix (Constants.kt)

Added `AppTarget(version = "2026.42.0", minSdk = 29, isExperimental = true)`.
Commit style for this change set (Doom convention): `bump: reddit 2026.42.0`.

## ⚠️ Not covered by this pass

- Modern-feed **banner/promo sections** (the old AdPostSection layer): needs a
  fresh statically-verifiable anchor for 2026.42.0 (assembly lives in
  GraphQL→`an0`/`b6j` binder pipeline; no single safe injection point found
  without runtime traces). Promoted *items* remain filtered at the Listing layer.
- Server-side premium perks (r/lounge, coins) — unpatchable by design.
- runtime smoke test on device — requires building the bundle (JDK 21 + PAT).
