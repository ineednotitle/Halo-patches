# Security Analysis — doom-reddit-patches

**Date:** 2026-10-23 · **Scope:** patch code (our `reddit/` patches + extension), imported upstream suite (537 files / 220 apps), and the build/CI supply chain · **Commit audited:** `9563220` (v1.2.4)

---

## 1. Executive summary

**Verdict: no malicious or dangerous code found.** The bundle is a legitimate patch pack in the ReVanced/Morphe lineage. The *injected runtime code* (the only part that executes inside patched apps) is 120 lines of defensive Java with no network, exec, or reflection-loading surfaces. The risk profile nonetheless has three **medium-severity** items: supply-chain pinning (mutable action tags, unverified gradle wrapper binary), and two *user-behavior* risk classes inherent to what's imported (signature/integrity spoofing helpers, cert-verification bypasses).

This is **not** an audit of the patches' *effects* on target apps' licenses/terms — only security posture.

## 2. What was checked

| Area | Method | Result |
|---|---|---|
| Extension runtime code (`.mpe` payload, `RedditFeedHelper.java`) | full read | ✅ Clean |
| Reddit patch smali injections (premium, flags, remove-ads) | authored this session; re-read | ✅ Safe mechanics |
| 537-file upstream suite | keyword surface scan + risk-class sampling | ⚠️ Risk-classes documented (§4B) |
| Dynamic-code/network surfaces across whole tree | grep sweep | ✅ None (see §4B results table) |
| Committed secrets / tokens | `git grep` of full history patterns | ✅ Only placeholders |
| CI/CD workflows | full read of both workflows + build config | ⚠️ Tag-pinned actions (§5) |

## 3. Injected runtime — the part that matters most

Only two things ever execute inside a user's patched app:

1. **Tiny smali stubs** (a few instructions each: `const/16 vN, 0x1` / `sget-object Boolean` / invoke-static helper / early `return-void`). No data collection, no network, no IPC. Register arithmetics were empirically verified against the smali tree-walker this week (the `const/4`→`const/16` root-cause), so the ART verifier classes are respected.
2. **`RedditFeedHelper`** — the ad-filter runtime:
   - No network calls, no `exec`, no native loading, no file I/O, no IPC ⚠️ grep-verified
   - **Safe-mode design**: every reflective call is wrapped in `catch (Throwable)` → on any model-drift it treats the item as regular content (fails open to *showing* an occasional ad, never to crashing the feed)
   - Bounded cost: a `ConcurrentHashMap` class→getter cache; linear scans over the visible list only
   - Reflection is read-only (getter invoke); no `setAccessible` on sensitive state, no writes

**Privacy impact of our Reddit patches:** *reducing* Reddit's telemetry footprint (click-tracking flag forced off at the data-source level). The account-flag spoofs (`can_create_subreddit`, `password_set`, `has_verified_email`, `is_employee`) are client-side cosmetic gates — they cannot mint server capabilities and cannot exfiltrate anything.

## 4. Imported upstream suite (220 apps) — risk register

The mesh is the standard patch-pack corpus. Surface scan of the full tree:

| Pattern class | Files found | Assessment |
|---|---|---|
| Billing / premium-gate flips | 159 (billing), 53 (LicenseCheck) | Intended purpose. ToS risk ≠ security risk. Server-validated flows still fail server-side — these are this pack's raison d'être. |
| **Signature spoofing** (`SpoofSignature`) | 20 | ⚠️ **Medium.** Enables patched apps to assert a forged signing-certificate identity to the package manager (microG-style). Harmless where the ROM doesn't honor the permission grant; potentially dangerous if combined with untrusted sideloaded apps. Only enable on apps you also trust unpatched. |
| **Play-integrity / pairip bypasses** | ~80 | ⚠️ **Medium (user-protection angle).** These defeat the app's own tamper-detection. On a legitimately-downloaded APK: fine. On a *repacked* APK: the same bypass could hide genuine malware tampering. Defense: only patch APKs from first-party sources (mirrors with signature check — which the manager does via our `signatures` SHA-256 pin for Reddit). |
| Anti-tamper / frida / xposed detector kills | 10–13 | Same note as above — they hide instrumentation from the app. |
| Cert-pinning / Firebase cert-hash spoof | 1 + shared helpers | ⚠️ Weakens TLS validation of the patched app where enabled (cert-pinning bypass → MITM theoretically easier). Recommend leaving such patches OFF unless you specifically need them. |
| Dynamic loading / exec / sockets / native loads | **0** real matches across the corpus | ✅ (matches were the build-time `PatchListGenerator` classloader and comment references) |
| Hardcoded URLs in patch code | **0** | ✅ Nothing phones home. |
| Base64/blob payloads | none >100KB | ✅ No hidden payloads. Waze Lua resources are text assets. |

*Sampling note:* keyword-hits were spot-read (e.g. `PairIp.kt`, `SpoofFirebaseCertHashPatch.kt`, AAGuard/Spotify-adjacent billing packs) — they are conventional implementations of their described function (force boolean flags / stub loaders / constant returns), not masqueraded behavior.

## 5. Supply chain & CI/CD

| Item | Status | Severity |
|---|---|---|
| GitHub Actions pinned by **version tags** (`@v4`–`@v7`) not commit SHAs | Tags are movable → tag-hijack could inject code into release builds | 🟡 Medium → *fix recommended* |
| `gradle-wrapper.jar` committed (from upstream `rushiranpise/morphe-patches`), SHA-256 `7a9ce74c…625d` | Executes on every build; unverified against official Gradle 9.7.0 wrapper | 🟡 Medium/low → *verify or replace* |
| Build provenance attestation (`actions/attest-build-provenance@v4`) on every release | ✅ Enabled — strong integrity signal | ✅ Good |
| `GITHUB_TOKEN` usage | Build job `contents: read` (job-level restriction ✓); release job needs write (semantic-release) ✓ minimal | ✅ Good |
| GitHub Packages credentials | Passed via env (`gpr.user/gpr.key` fall back to `GITHUB_ACTOR/GITHUB_TOKEN`); **no token committed** (`gradle.properties` has placeholders only) | ✅ Good |
| Actual secrets in git history | `git grep`: only `ghp_YOUR_TOKEN`-style placeholders | ✅ Clean |
| Fine-grained PAT used by assistant for pushes (Contents RW, this repo only) | Scoped correctly but **still live** | 🔴 Open action — delete it |
| `build.log` uploaded as CI artifact on failure | Contains gradle output; token values are not echoed (env-scoped) | ✅ Acceptable |
| Distro downloads (JDK via `setup-java`, deps via `npm install` w/ existing `package-lock.json`) | Temurin distro + locked npm deps | ✅ Reasonable |
| Release asset checksums | attestation covers provenance; optional SHA-256 sidecar possible | ℹ️ Nice-to-have |

## 6. Recommendations (ranked)

1. **Delete the fine-grained PAT now** — task it's for is complete. https://github.com/settings/personal-access-tokens
2. **Pin all GitHub Actions to full commit SHAs** (keep the tag as a trailing comment for readability; e.g. `uses: actions/checkout@<sha> # v7`).
3. **Verify the gradle wrapper** against the official Gradle 9.7.0 distribution (`./gradlew wrapper --gradle-version 9.7.0 --distribution-type bin --gradle-distribution-sha256-sum <official>`) or replace the jar from a first-party download.
4. **Add a short "risk legend" to README** marking the security-sensitive patch classes from §4B (signature spoof, pairip/anti-tamper, cert/firebase-hash spoof) so users understand what they're enabling app-by-app.
5. *Optional:* publish `SHA256SUMS.txt` of release assets (like upstream does) for out-of-band verification.
6. *Optional, repo hygiene:* enable branch protection on `main` requiring the Release workflow (it has write perms) to pass — friction-free for a solo repo and stops accidental direct pushes.

## Addendum — mitigations applied (commit after audit)

- ✅ **GitHub Actions SHA-pinned** in `build.yml`, `release.yml`, `open_pull_request.yml`
  (`checkout` `3d3c42e5`, `setup-java` `b6effb05`, `setup-node` `949feb24`,
  `upload-artifact` `ea165f8d`, `semantic-release-action` `b12c8f60`,
  `attest-build-provenance` `8beda2b7`), each retaining `# vX` comments.
- ✅ **Gradle wrapper jar verified unmodified** — SHA-256
  `7a9ce74cff467ca1bf60a4fcd9f05185acceda4d0f382434d393e17864262c5d` is
  byte-identical to gradle/gradle @ `v9.7.0`'s own wrapper. No replacement needed.
- ✅ **Distribution already pinned** — `distributionSha256Sum` was present upstream and
  matches gradle.org's official checksum for 9.7.0-bin ✓ re-verified against
  the first-party checksum page and a fresh download.
- ✅ **Risk legend added to README** covering signature/integrity/cert/billing classes.
- ⏳ Still owner actions: delete the fine-grained PAT; optional branch protection.

## 7. Bottom line

Ship as-is: PAT deletion is the only open owner action.

## 6. Recommendations (ranked) — historical; see addendum above for status
