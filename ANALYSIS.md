# How "Doom's Morphe Patches" (rushiranpise/morphe-patches) Works — Full Analysis

Analyzed from the live repo (main @ v1.23.0, Oct 2026) and release v1.18.3.

---

## 1. What the project actually is

`rushiranpise/morphe-patches` is **not a customized Morphe Manager app** and it is **not the
official MorpheApp/morphe-patches repo**. It is a **third-party patch bundle** — a Gradle
project that compiles patch code into a **`.mpp` file** (a patch bundle jar). Morphe Manager /
Morphe Desktop load that bundle and apply its patches to an APK the user supplies.

- The README literally says: *"Just some patches I make in my free time, with a little (most :p)
  help from AI… Everything here is AI-generated, then tested enough to not explode."*
- Every release (e.g. v1.18.3) ships the same 6 assets:
  - `patches-<version>.mpp` — the patch bundle (this is the real product)
  - `patches-<version>.mpp.asc` — signature
  - `patches-bundle.json` — the **remote patch source** Morphe Manager polls for updates
  - `patches-list.json` — machine-readable patch metadata (names, options, compatibilities)
  - `SHA256SUMS.txt`, `PATCHES.md`
- Users add `https://github.com/rushiranpise/morphe-patches` as a **patch source** inside Morphe
  Manager (expert mode). That is the entire UX.
- Important: the repo patches ~250 **miscellaneous apps** (AccuBattery, Amazon, Word, Excel…).
  It does **not** contain Reddit patches — Reddit is owned by the official MorpheApp repo.
  So to make "a Doom's patch for the Reddit app", we replicate his *project setup and patch
  style*, but target `com.reddit.frontpage`.

## 2. The foundation: it's the official template, barely renamed

He generated his repo from `MorpheApp/morphe-patches-template` and kept the template defaults:

- Gradle plugin at the root: `id("app.morphe.patches") version "1.3.3"`
  (`settings.gradle.kts`). This one plugin wires everything: it includes the `patches` and
  `extensions/extension` modules, pulls in `morphe-patcher` (the dex/patching engine, forked
  from ReVanced), and registers the `buildAndroid` task that produces the `.mpp`.
- The Kotlin source package is still `app.template.patches` and the extension package is
  still `app.template.extension` — he never renamed the template namespace. (`group` in
  `patches/build.gradle.kts` is only used for Maven coordinates.)
- The plugin resolves from GitHub Packages `MorpheApp/registry`, so **building locally requires
  a GitHub PAT** (`gpr.user`/`gpr.key` in `gradle.properties` or `GITHUB_ACTOR`/`GITHUB_TOKEN`).

### Repo layout (what matters)

```
├── settings.gradle.kts            # plugin mgmt + app.morphe.patches plugin
├── gradle.properties              # version = 1.23.0  (bumped by semantic-release)
├── package.json + .releaserc      # semantic-release toolchain (see §5)
├── patches/
│   ├── build.gradle.kts           # about{} block = bundle metadata shown in Morphe Manager
│   └── src/main/kotlin/
│       ├── app/template/patches/  # one folder per app, per-patch folders below that
│       │   ├── shared/            # Constants.kt (all Compatibility defs) + util helpers
│       │   └── <app>/<feature>/   # Fingerprints.kt + <Name>Patch.kt
│       └── util/PatchListGenerator.kt   # release-time patches-list.json generator
├── extensions/extension/
│   ├── build.gradle.kts           # android library compiled to extensions/extension.mpe
│   └── src/main/java/app/template/extension/extension/*.java  # runtime helpers
└── .github/workflows/             # release.yml, open_pull_request.yml, sync_tracker_config.yml
```

## 3. Anatomy of a single patch (his recipe)

Every patch follows the exact same 3-piece recipe (example: `accubattery/premium/`):

### Piece 1 — `Constants.kt` entry (shared registry)

```kotlin
val ACCUBATTERY_COMPATIBILITY = Compatibility(
    name = "AccuBattery",
    packageName = "com.digibites.accubattery",
    apkFileType = ApkFileType.APK,          // APK / APKM / APKS / XAPK — tells Morphe what bundle type to expect
    appIconColor = 0x00BCD4,
    targets = listOf(AppTarget(version = "2.1.8", versionCode = 201008))
)
```
One per app; a CI sorter script keeps the file alphabetically sorted.

### Piece 2 — `Fingerprints.kt` (find obfuscated smali)

Apps are obfuscated (DexGuard/R8), so patch targets can't be referenced by name. A
`Fingerprint` finds a method by *what it does*, not what it's called:

```kotlin
object OfferIsValidFingerprint : Fingerprint(
    returnType = "Z",                                        // returns boolean
    accessFlags = listOf(AccessFlags.PUBLIC),
    parameters = listOf(),
    filters = listOf(
        opcode(Opcode.CONST_WIDE_32),                        // the 86400000L grace-period literal
        methodCall(definingClass = "Ljava/lang/System;", name = "currentTimeMillis"),
    )
)
```
Filter types used across the repo: `opcode(...)`, `methodCall(...)`, `fieldAccess(...)`,
`string("...")`, plus signature constraints (`returnType`, `parameters`, `accessFlags`,
`definingClass`, `classFingerprint` to scope a search to a previously-found class).
Every fingerprint carries a long comment block: which smali file/line the anchor came from,
why each filter is unique, and how to re-verify after an app update.

### Piece 3 — `<Name>Patch.kt` (do the surgery)

```kotlin
@Suppress("unused")
val accuBatteryPremiumPatch = bytecodePatch(
    name = "Unlock Premium",
    description = "...",
    default = true                       // selected by default in Morphe's UI
) {
    compatibleWith(ACCUBATTERY_COMPATIBILITY)
    extendWith("extensions/extension.mpe")   // (only when an extension helper is needed)

    execute {
        OfferIsValidFingerprint.method.returnEarly(true)   // wipe body → `const/4 v0, 0x1; return v0`
        ...
    }
}
```

**Body-rewrite toolbox he uses (shared/MethodExtensions.kt):**
- `returnEarly(true/false)` — replace a gate method with an immediate constant return.
- `clearBody()` — remove every instruction **and purge the try/catch table via reflection**
  (leaving stale try ranges → ART `VerifyError`).
- `ensureRegisters(n)` — grow `.registers N` via reflection before injecting smali that
  needs scratch registers.
- `addInstructions(index, "...smali...")` / `addInstructionsWithLabels` — inject raw smali.
- `replaceInstruction` — surgical single-instruction swaps.
- `classDefForEach { ... }` + `mutableClassDefByOrNull(...)` — brute-force class scans with
  **structural heuristics** when fingerprints alone can't name a target (e.g. "the class is an
  `OnSharedPreferenceChangeListener` with ≥4 fields of type AppLovinIncentivizedInterstitial").

**His most distinctive habit** — everything is painfully documented: which methods are coroutine
state machines that must *not* be `clearBody`'d (packed-switch tables die), which register
frames explode, what VerifyError was observed, and exactly how to re-derive the anchor from a
fresh apktool dump when the app updates.

### Piece 4 (optional) — the `.mpe` extension

When a patch needs real runtime logic (not just a smali flip), he writes a plain Java helper
(e.g. `AmazonHelper.java`), compiles it as an Android library into `extension.mpe`, pulls it
into the patch with `extendWith("extensions/extension.mpe")`, then calls it from injected
smali:

```
invoke-static {p1}, Lapp/template/extension/extension/AmazonHelper;->injectAdBlock(Landroid/webkit/WebView;)V
```
The extension ships inside the `.mpp` bundle and is merged into the target app's dex at patch
time. (Fans of ReVanced: same idea as `integrations`.)

## 4. Where his fingerprints come from (the development loop)

From the comments and commit history, the loop is:

1. Download target APK → decompile (`apktool d` / JADX / smali dump).
2. Hunt the feature gate manually (with LLM assistance per the README): subscription checks,
   ad-list adapters, `isPremium()`-style booleans.
3. Pick **stable anchors**: unique numeric literals (86400000L), JDK calls
   (`System.currentTimeMillis`), interface/field structure, field-type signatures — things
   obfuscators rarely change.
4. Write fingerprint + patch, build: `./gradlew buildAndroid` →
   `patches/build/libs/patches-*.mpp`.
5. Test by applying the local `.mpp` with Morphe Desktop / Manager against the real APK.
6. Commit with conventional-commit messages (`feat:`, `fix:`, `bump:`) — CI does the rest.

## 5. The release pipeline (why every release looks identical)

Fully automated with **semantic-release** (`.releaserc`):

- Branches: `dev` (pre-releases like `1.19.0-dev.6`) → auto-PR → `main` (stable).
- Conventional commits drive versions: `fix:` → patch, `feat:` → minor.
- Release steps (`release.yml` + `@semantic-release/exec`):
  1. `./gradlew generatePatchesList` → builds the `.mpp` **and** emits `patches-list.json`
     (patch names, descriptions, options, compatibilities — via `util/PatchListGenerator.kt`).
  2. `@MorpheApp/changelog` generates `patches-bundle.json` pointing at the release URL —
     **this JSON is the remote patch source Morphe Manager consumes**.
  3. `SHA256SUMS.txt` + `actions/attest-build-provenance` (the `.mpp.asc` provenance).
  4. `@semantic-release/git` commits CHANGELOG/README/PATCHES.md back; backmerge main→dev.
- `verify project compiles` step runs on non-release branches so broken patches never merge.

## 6. Summary of the "Doom method" we will replicate

| Step | What he does | Our Reddit equivalent |
|---|---|---|
| 1 | Use `morphe-patches-template` as-is (keep `app.template.*`) | Same |
| 2 | `Compatibility` entry per app in shared `Constants.kt` | Reddit (`com.reddit.frontpage`, APKM, icon `#FF4500`) |
| 3 | `Fingerprint` = signature + opcode/methodCall/string filters with heavy docs | Real Reddit anchors: `Listing` constructor field writes, `AdPostSection(linkId=` toString, `CommentsViewModel` ad loader, `CommentsAdState(...adsLoadCompleted=` |
| 4 | Patch = `bytecodePatch { compatibleWith; extendWith; execute { smali surgery } }` | Feed-list ad filtering + comment-ad short-circuit; premium-gate `returnEarly(true)` |
| 5 | Java extension helper merged via `extendWith` | `RedditFeedHelper.java` feed/ad flag filtering |
| 6 | `./gradlew buildAndroid` → test `.mpp` with Morphe Desktop | Same |
| 7 | semantic-release CI → `.mpp` + `patches-bundle.json` release assets | Same workflow files |

Legality/etiquette notes Doom states (worth keeping): patches are user-side modifications for
personal use, no copyrighted APK content is distributed (the bundle contains *instructions*,
not app code), and everything is GPLv3 with attribution when derived from other GPL sources.
