# 👋🧩 Doom's Reddit Patches

> *New mask, same task. Doom's patches for the Reddit app.*

A **Morphe patch bundle** for `com.reddit.frontpage`, built by cloning the exact
recipe used by [rushiranpise/morphe-patches](https://github.com/rushiranpise/morphe-patches)
("Doom's Morphe Patches") — which itself is generated from the official
[morphe-patches-template](https://github.com/MorpheApp/morphe-patches-template).
See [ANALYSIS.md](ANALYSIS.md) for the full teardown of Doom's method.

## 🧩 Patches

<!-- PATCHES_START -->

| Patch | What it does |
|---|---|
| **Remove ads** | Filters promoted posts out of feed list surfaces and kills banner ads (and their placeholders) in comment threads. Anchors verified on **2026.42.0** — see [VERIFICATION_2026.42.0.md](VERIFICATION_2026.42.0.md). |
| **Unlock Premium** | Data-source surgery in `AccountJsonAdapter.fromJson`: pins `is_gold`, `has_gold_subscription`, `has_premium_avatar_treatment` to true at both Account construction sites (registers computed at patch time from the Moshi options table — no hardcoded offsets). Premium app surface unlocked; server-validated perks (r/lounge, coins) cannot be unlocked by any local patch. **Verified on 2026.42.0.** |

<!-- PATCHES_END -->

## 🔨 Build (the Doom pipeline)

Prerequisite: a GitHub **Personal Access Token** with `read:packages`
(the Morphe patcher engine resolves from the GitHub Packages `MorpheApp/registry`).

```bash
# 1. Put your credentials in gradle.properties
echo "gpr.user=YOUR_USERNAME"   >> gradle.properties
echo "gpr.key=ghp_YOUR_TOKEN"   >> gradle.properties

# 2. Build the bundle
./gradlew buildAndroid
# → patches/build/libs/patches-1.0.0.mpp
```

## 📱 Test it

**Morphe Desktop** (drag-drop GUI): open the tool, select your Reddit APK/APKM,
pick `patches-*.mpp` as the patch bundle, select patches, Patch.

**Morphe Manager (Android)**: Settings → enable **Expert mode** → Patch bundles →
`+` → load the local `.mpp` file → select the Reddit app.

Get the Reddit APK as a **APKM/APKS bundle** (Play Store serves app bundles);
Morphe merges splits automatically.

## 🚀 Release (semantic-release, like Doom)

1. Push this repo to GitHub. Enable **Settings → Actions → General →
   "Allow GitHub Actions to create and approve pull requests"**.
2. Work on the `dev` branch. Conventional commits drive versions:
   `feat:` → minor, `fix:`/`bump:`/`perf:` → patch.
3. Every push to `dev` → pre-release (`1.1.0-dev.1`) + auto-PR to `main`.
   Merge the PR → stable release with:
   - `patches-<version>.mpp` (+ attestation)
   - `patches-bundle.json` ← the **remote patch source** for Morphe Manager
   - `patches-list.json`, `SHA256SUMS.txt`
4. Users then add `https://github.com/YOU/doom-reddit-patches` as a patch
   source in Morphe Manager.

## 🛠 When Reddit updates and a patch breaks (fingerprint maintenance)

Doom's workflow, from his comments/docs:

1. `apktool d reddit.apkm` (or JADX) on the new APK.
2. Re-check each anchor — the exact commands are documented in each
   `Fingerprints.kt` header:
   - `smali*/com/reddit/domain/model/listing/Listing.smali` field writes
   - `smali*/com/reddit/comments/presentation/CommentsViewModel.smali` ad loader
   - `grep -rl '"CommentsAdState(conversationAdViewState="' smali*/`
   - `grep -rln '"is_gold"' smali*/ | grep -i adapter`
3. Fix filters → `./gradlew buildAndroid` → test → commit `fix: reddit 2026.xx.0`.
4. Version bump of supported targets goes in
   `patches/src/main/kotlin/app/template/patches/shared/Constants.kt` (single source of truth).

## ⚠️ Disclaimer

User-side modification of an app for personal use; nothing from the original
APK is distributed (the `.mpp` contains patch *instructions* only). Reddit's
ToS may prohibit modified clients — you are responsible for how you use this.
GPLv3. Anchoring strategy adapted with attribution from
[MorpheApp/morphe-patches](https://github.com/MorpheApp/morphe-patches) (GPLv3).
