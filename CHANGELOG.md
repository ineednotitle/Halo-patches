## [1.6.4](https://github.com/ineednotitle/Halo-patches/compare/v1.6.3...v1.6.4) (2026-10-24)

### 🐛 Bug Fixes

* Strava login/join broken by forced password-only flag - split OTP bypass into opt-in patch ([caa9584](https://github.com/ineednotitle/Halo-patches/commit/caa9584f7db560ce1d8a19f87980af97cf577dd5))

## [1.6.3](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.6.2...v1.6.3) (2026-10-24)

### 🐛 Bug Fixes

* rebrand to Holopatch Patches ([5f60331](https://github.com/ineednotitle/doom-reddit-patches/commit/5f60331de6007e2a38e0d1d683421fd5ec62ca9f))

## [1.6.2](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.6.1...v1.6.2) (2026-10-24)

### 🐛 Bug Fixes

* remove Nothing Launcher and Nothing Widgets patches ([9c3a6d8](https://github.com/ineednotitle/doom-reddit-patches/commit/9c3a6d81d7718a538068ce052089f8a472d7cee4))

## [1.6.1](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.6.0...v1.6.1) (2026-10-24)

### 🐛 Bug Fixes

* Nothing Launcher - add drawer icon so the app can be opened on other ROMs ([6932376](https://github.com/ineednotitle/doom-reddit-patches/commit/693237613f5eb0fd5a36132b14b03061b3b4e5d5))

## [1.6.0](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.5.0...v1.6.0) (2026-10-24)

### ✨ New Features

* Nothing Launcher 3.3.10 - universal compatibility + block analytics ([6dbefd5](https://github.com/ineednotitle/doom-reddit-patches/commit/6dbefd571875ce4986a34029134ccec19d32176b))

## [1.5.0](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.4.1...v1.5.0) (2026-10-24)

### ✨ New Features

* Nothing Widgets 3.4.1 - Universal Android compatibility (ColorOS/realme UI) ([561ba6b](https://github.com/ineednotitle/doom-reddit-patches/commit/561ba6b97eb5e7aeca48f80104a053378a1f20cd))

## [1.4.1](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.4.0...v1.4.1) (2026-10-24)

### 🐛 Bug Fixes

* import missing AmazonHelper/AmazonUrls extension + fix darkmode register clobber + verify vs Amazon India 32.19.0.300 ([962c47d](https://github.com/ineednotitle/doom-reddit-patches/commit/962c47dad76867ffb7ed29aacacc51c2f471a7ea))

## [1.4.0](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.3.1...v1.4.0) (2026-10-24)

### ✨ New Features

* Everything Widgets 2.1.014 — unlock premium, spoof Play signature, remove tracking ([21ae0e9](https://github.com/ineednotitle/doom-reddit-patches/commit/21ae0e95d4c71d9a4c829a0efc9789e35d37e630))

## [1.3.1](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.3.0...v1.3.1) (2026-10-23)

### 🐛 Bug Fixes

* **district:** CleverTap profile-push fingerprint anchored to a phantom const ([5bf88d8](https://github.com/ineednotitle/doom-reddit-patches/commit/5bf88d880890e135c9908536e38ae0244bfcc94d))

## [1.3.0](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.2.6...v1.3.0) (2026-10-23)

### ✨ New Features

* District by Zomato 2.76.0 — block analytics & data collection, block location tracking ([4c0d139](https://github.com/ineednotitle/doom-reddit-patches/commit/4c0d13936b7208c92adb2ea2b733816fdf9430a3))

## [1.2.6](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.2.5...v1.2.6) (2026-10-23)

### 🐛 Bug Fixes

* **perf:** remove dead hideNewPostAds entry point from extension ([ab792a8](https://github.com/ineednotitle/doom-reddit-patches/commit/ab792a8b5b9d507cb7b89faf42ce6c78d470c9a6))

## [1.2.5](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.2.4...v1.2.5) (2026-10-23)

### 🐛 Bug Fixes

* **perf:** null-safe reflection cache in RedditFeedHelper + performance audit ([bb6ca9d](https://github.com/ineednotitle/doom-reddit-patches/commit/bb6ca9d74b5c6bedc4ad854cd18e7f51eb610b08))

## [1.2.4](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.2.3...v1.2.4) (2026-10-23)

### 🐛 Bug Fixes

* **reddit:** kill AdPostSection render composables — 42.0 feed-ad path ([145ce53](https://github.com/ineednotitle/doom-reddit-patches/commit/145ce53256c4a54e71f2b307e769ffaaa2533c34))
* **reddit:** missing AccessFlags import in RemoveAdsPatch ([9563220](https://github.com/ineednotitle/doom-reddit-patches/commit/9563220cb4aacb635308b6bb16f94b16b1df3e60))

## [1.2.3](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.2.2...v1.2.3) (2026-10-23)

### 🐛 Bug Fixes

* **reddit:** const/16 for registers above v15 (root-caused via local smali repro) ([812a94a](https://github.com/ineednotitle/doom-reddit-patches/commit/812a94ab9f90a6814c5dcb570ede5144c472c2a8))
* **reddit:** inject BuilderInstructions directly, bypass the inline smali compiler ([d6d51fa](https://github.com/ineednotitle/doom-reddit-patches/commit/d6d51fae46d9655150d41d5b89d3e2aca8f86839))

## [1.2.2](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.2.1...v1.2.2) (2026-10-23)

### 🐛 Bug Fixes

* **reddit:** upstream-probed constructor fingerprint for options ctor ([9722576](https://github.com/ineednotitle/doom-reddit-patches/commit/972257612df05f8cdd30e25cbcd3a8b14e56eae0))

## [1.2.1](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.2.0...v1.2.1) (2026-10-23)

### 🐛 Bug Fixes

* **reddit:** promote 2026.42.0 from experimental to fully supported ([5c08749](https://github.com/ineednotitle/doom-reddit-patches/commit/5c08749fe8771e8f4ce32a1c1c496ba76614612b))

## [1.2.0](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.1.0...v1.2.0) (2026-10-23)

### ✨ New Features

* **reddit:** 3 new account-flag patches (bytecode-selected, 2026.42.0) ([b7eb077](https://github.com/ineednotitle/doom-reddit-patches/commit/b7eb0771d4f80d61d8f38532e1c6a0d109de1b06))

## [1.1.0](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.0.6...v1.1.0) (2026-10-23)

### 🐛 Bug Fixes

* close patches{} block and keep our group id in the imported build file ([7fc47de](https://github.com/ineednotitle/doom-reddit-patches/commit/7fc47de52a93618797a4e50b1919884c895b468c))
* nest REDDIT_COMPATIBILITY inside the imported object Constants ([101617e](https://github.com/ineednotitle/doom-reddit-patches/commit/101617e627a640ebe1117732ebb63f9cda47d9b7))

### ✨ New Features

* import the full Doom/Morphe patch suite (220 apps) from rushiranpise/morphe-patches ([f5bfe52](https://github.com/ineednotitle/doom-reddit-patches/commit/f5bfe52082fa9692494472ca369efa021abf4256))

## [1.0.6](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.0.5...v1.0.6) (2026-10-23)

### 🐛 Bug Fixes

* make premium fingerprints version-robust across Reddit builds ([fddf187](https://github.com/ineednotitle/doom-reddit-patches/commit/fddf1879d4afe09adaa1d8dba32d5cf6376fdb77))

## [1.0.5](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.0.4...v1.0.5) (2026-10-23)

### 🐛 Bug Fixes

* mirror the reference pack's proven fingerprint style and build stack ([1afda64](https://github.com/ineednotitle/doom-reddit-patches/commit/1afda640e72d4aef79d8d758fdc6f1ea974408d4))
* vendor PatchListGenerator from the reference pack (own app.morphe.util copy) ([2e28cff](https://github.com/ineednotitle/doom-reddit-patches/commit/2e28cffc226e510cb2138ea6e1f05ab3133562c5))

## [1.0.4](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.0.3...v1.0.4) (2026-10-22)

### 🐛 Bug Fixes

* build against app.morphe.patches plugin 2.0.0 (Patcher 2.0 ABI) ([585b0a1](https://github.com/ineednotitle/doom-reddit-patches/commit/585b0a183f502e12f92150b06119ecd45aea9126))
* compile against patcher API 2.0.0, not 1.8.0 ([3a5c622](https://github.com/ineednotitle/doom-reddit-patches/commit/3a5c6220d93969b6a603154e719749e849a2a8ac))
* vendor util.PatchListGenerator (moved from the plugin into template source) ([a0b1998](https://github.com/ineednotitle/doom-reddit-patches/commit/a0b199864d8ef11d5889c3c642f914498fe26bb4))

## [1.0.3](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.0.2...v1.0.3) (2026-10-22)

### 🐛 Bug Fixes

* disambiguate adapter ctor by options-array fill, drop definingClass pins ([52af0e8](https://github.com/ineednotitle/doom-reddit-patches/commit/52af0e8fb0f9292d471ff2c80d50e8aad17f67b6))

## [1.0.2](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.0.1...v1.0.2) (2026-10-22)

### 🐛 Bug Fixes

* pin premium fingerprints to AccountJsonAdapter and skip non-boolean params ([c9d73d8](https://github.com/ineednotitle/doom-reddit-patches/commit/c9d73d886924c789b868f31e399b7c0c78cb3264)), closes [12/#14](https://github.com/12/doom-reddit-patches/issues/14)

## [1.0.1](https://github.com/ineednotitle/doom-reddit-patches/compare/v1.0.0...v1.0.1) (2026-10-21)

### 🐛 Bug Fixes

* add missing extension manifest and release config ([0c7de34](https://github.com/ineednotitle/doom-reddit-patches/commit/0c7de3442b8e62afa8aa2841588d408f0472d275))
* break up '*/' sequences inside KDoc comments ([cebb3f4](https://github.com/ineednotitle/doom-reddit-patches/commit/cebb3f4712bcf5878d3290def335591e03c224fc))
* port register-range reads to the Morphe smali dialect ([d08aadf](https://github.com/ineednotitle/doom-reddit-patches/commit/d08aadfdabdeabbe3f877c5d59d95e57664f289d))
* qualify addInstructions with the fromJsonMethod receiver ([07b357c](https://github.com/ineednotitle/doom-reddit-patches/commit/07b357c3d854b1d7b5d8be60deca4312b9da512a))
