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
