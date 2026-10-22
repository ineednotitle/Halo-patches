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
