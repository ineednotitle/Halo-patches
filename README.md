# 👋🧩 Doom's Reddit Patches

> *New mask, same task. Doom's patches for the Reddit app.*

A **Morphe patch bundle** for `com.reddit.frontpage`, built by cloning the exact
recipe used by [rushiranpise/morphe-patches](https://github.com/rushiranpise/morphe-patches)
("Doom's Morphe Patches") — which itself is generated from the official
[morphe-patches-template](https://github.com/MorpheApp/morphe-patches-template).
See [ANALYSIS.md](ANALYSIS.md) for the full teardown of Doom's method.

## 🧩 Patches

<!-- PATCHES_START -->
> **[v1.2.0](https://github.com/ineednotitle/doom-reddit-patches/releases/tag/v1.2.0)**&nbsp;&nbsp;•&nbsp;&nbsp;`main`&nbsp;&nbsp;•&nbsp;&nbsp;322 patches total
<details>
<summary>📦 AAAD&nbsp;&nbsp;•&nbsp;&nbsp;2 patches</summary>
<br>

**🎯 Supported versions:**

| 2.8.5 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [AAAD Premium](#aaad-premium) | Unlocks AAAD Pro subscription features by bypassing Stripe and Firebase subscription checks. |  |
| [AAAD Security Bypass](#aaad-security-bypass) | Disables AAAD's anti-tamper, anti-debug, and integrity checks to allow running on patched installations. |  |

</details>

<details>
<summary>📦 Google Photos&nbsp;&nbsp;•&nbsp;&nbsp;7 patches</summary>
<br>

**🎯 Supported versions:**

| 7.97.0.997578476 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [AMOLED dark theme](#amoled-dark-theme) | Makes Google Photos dark surfaces true black. |  |
| [Change package name](#change-package-name) | Installs Google Photos beside the system Photos app by changing package, permissions, providers, and app name. | • Package name<br>• App name |
| [Custom branding](#custom-branding) | Adds an option to replace the Google Photos launcher icon. | • Custom icon |
| [Enable DCIM folders backup control](#enable-dcim-folders-backup-control) | Allows controlling Camera and other DCIM folder backup individually. |  |
| [Fix DCIM folder classification](#fix-dcim-folder-classification) | Prevents non-Camera DCIM folders from being grouped as Camera. |  |
| [GmsCore support](#gmscore-support) | Adds MicroG/GmsCore support metadata for Google Photos. |  |
| [Spoof features](#spoof-features) | Spoofs selectable Pixel Photos build and feature flags. | • Pixel profile<br>• Android version<br>• Override ROM feature levels |

</details>

<details>
<summary>📦 Messenger&nbsp;&nbsp;•&nbsp;&nbsp;13 patches</summary>
<br>

**🎯 Supported versions:**

| 576.0.0.47.92 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Allow screen capture](#allow-screen-capture) | Allows screenshots and screen recording in all conversations including end-to-end encrypted ones. |  |
| [Block screenshot detection](#block-screenshot-detection) | Prevents Messenger from notifying other participants when you take a screenshot or screen recording. |  |
| [Change package name](#change-package-name) | Installs Messenger beside the original by renaming the manifest package and provider authorities, removing duplicate permission declarations. | • Package name<br>• App name |
| [Disable media transcoding](#disable-media-transcoding) | Sends photos and videos at original quality without re-encoding. |  |
| [Disable typing indicator](#disable-typing-indicator) | Disables the indicator while typing a message. |  |
| [Enable chat heads](#enable-chat-heads) | Enables chat heads (bubbles) for all devices regardless of API level or RAM class. |  |
| [Hide Facebook buttons](#hide-facebook-buttons) | Hides buttons and shortcuts that open Facebook. |  |
| [Hide inbox ads](#hide-inbox-ads) | Hides ads in the Messenger inbox. |  |
| [Hide inbox stories and notes tray](#hide-inbox-stories-and-notes-tray) | Hides the stories and notes horizontal tray at the top of the inbox. |  |
| [Hide inbox subtabs](#hide-inbox-subtabs) | Hides Home and Channels tabs between active now tray and chats. |  |
| [Open links externally](#open-links-externally) | Opens links in the external browser instead of the in-app browser. |  |
| [Remove Meta AI](#remove-meta-ai) | Removes the Meta AI floating button, drawer items, and search suggestions. |  |
| [Spoof package version](#spoof-package-version) | Sets a very high version code so the Play Store treats the app as already up to date and never offers an update. | • Version code |

</details>

<details>
<summary>📦 Telegram&nbsp;&nbsp;•&nbsp;&nbsp;14 patches</summary>
<br>

**🎯 Supported versions:**

| 12.10.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Anti-delete messages](#anti-delete-messages) | Prevents messages deleted by other users from being removed locally. |  |
| [Anti-disappearing media](#anti-disappearing-media) | Keeps view-once photos, videos and voice messages viewable indefinitely. |  |
| [Anti-screenshot notification](#anti-screenshot-notification) | Blocks screenshot notifications from being sent to the other user. |  |
| [Bypass channel restrictions](#bypass-channel-restrictions) | Allows opening, viewing, saving and forwarding content from restricted, sensitive, and copyright-restricted channels. |  |
| [Bypass content restrictions](#bypass-content-restrictions) | Allows saving and forwarding content from restricted channels, chats, and users. |  |
| [Bypass integrity check](#bypass-integrity-check) | Spoofs certificate fingerprint and SafetyNet results so login works on patched APK. |  |
| [Disable auto-update](#disable-auto-update) | Disables automatic app update checks, the blocking update screen, and the proxy sponsor channel insertion. On Telegram Plus also disables the Plus-specific updater and update settings flag. |  |
| [Disable channel switching](#disable-channel-switching) | Disables the pull-down gesture that switches to the next unread channel. |  |
| [Download speed boost](#download-speed-boost) | Increases download chunk size to 1 MB and max concurrent requests to 12. |  |
| [Hide typing indicator](#hide-typing-indicator) | Hides your typing indicator from other users in all chats. On Telegram Plus also silences the controller-level sendTyping dispatcher. |  |
| [Remove ads](#remove-ads) | Removes sponsored messages and video ads from all chats and channels. On Telegram Plus also blocks native banner and inline ads. |  |
| [Unlock Premium](#unlock-premium) | Unlocks Telegram Premium features for the current account. |  |
| [Use normal paste](#use-normal-paste) | Skips Telegram's Rich HTML paste handler and falls back to the normal paste path. |  |
| [Voice to music](#voice-to-music) | Plays voice notes in the full music player with seek bar and background playback. |  |

</details>

<details>
<summary>📦 Telegram Web&nbsp;&nbsp;•&nbsp;&nbsp;14 patches</summary>
<br>

**🎯 Supported versions:**

| 12.10.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Anti-delete messages](#anti-delete-messages) | Prevents messages deleted by other users from being removed locally. |  |
| [Anti-disappearing media](#anti-disappearing-media) | Keeps view-once photos, videos and voice messages viewable indefinitely. |  |
| [Anti-screenshot notification](#anti-screenshot-notification) | Blocks screenshot notifications from being sent to the other user. |  |
| [Bypass channel restrictions](#bypass-channel-restrictions) | Allows opening, viewing, saving and forwarding content from restricted, sensitive, and copyright-restricted channels. |  |
| [Bypass content restrictions](#bypass-content-restrictions) | Allows saving and forwarding content from restricted channels, chats, and users. |  |
| [Bypass integrity check](#bypass-integrity-check) | Spoofs certificate fingerprint and SafetyNet results so login works on patched APK. |  |
| [Disable auto-update](#disable-auto-update) | Disables automatic app update checks, the blocking update screen, and the proxy sponsor channel insertion. On Telegram Plus also disables the Plus-specific updater and update settings flag. |  |
| [Disable channel switching](#disable-channel-switching) | Disables the pull-down gesture that switches to the next unread channel. |  |
| [Download speed boost](#download-speed-boost) | Increases download chunk size to 1 MB and max concurrent requests to 12. |  |
| [Hide typing indicator](#hide-typing-indicator) | Hides your typing indicator from other users in all chats. On Telegram Plus also silences the controller-level sendTyping dispatcher. |  |
| [Remove ads](#remove-ads) | Removes sponsored messages and video ads from all chats and channels. On Telegram Plus also blocks native banner and inline ads. |  |
| [Unlock Premium](#unlock-premium) | Unlocks Telegram Premium features for the current account. |  |
| [Use normal paste](#use-normal-paste) | Skips Telegram's Rich HTML paste handler and falls back to the normal paste path. |  |
| [Voice to music](#voice-to-music) | Plays voice notes in the full music player with seek bar and background playback. |  |

</details>

<details>
<summary>📦 Telegram Plus&nbsp;&nbsp;•&nbsp;&nbsp;15 patches</summary>
<br>

**🎯 Supported versions:**

| 12.10.1.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Anti-delete messages](#anti-delete-messages) | Prevents messages deleted by other users from being removed locally. |  |
| [Anti-disappearing media](#anti-disappearing-media) | Keeps view-once photos, videos and voice messages viewable indefinitely. |  |
| [Anti-screenshot notification](#anti-screenshot-notification) | Blocks screenshot notifications from being sent to the other user. |  |
| [Bypass channel restrictions](#bypass-channel-restrictions) | Allows opening, viewing, saving and forwarding content from restricted, sensitive, and copyright-restricted channels. |  |
| [Bypass content restrictions](#bypass-content-restrictions) | Allows saving and forwarding content from restricted channels, chats, and users. |  |
| [Bypass integrity check](#bypass-integrity-check) | Spoofs certificate fingerprint and SafetyNet results so login works on patched APK. |  |
| [Disable analytics](#disable-analytics) | Blocks Firebase analytics and event tracking in Telegram Plus. FirebaseApp.initializeApp() is preserved so push notifications keep working. |  |
| [Disable auto-update](#disable-auto-update) | Disables automatic app update checks, the blocking update screen, and the proxy sponsor channel insertion. On Telegram Plus also disables the Plus-specific updater and update settings flag. |  |
| [Disable channel switching](#disable-channel-switching) | Disables the pull-down gesture that switches to the next unread channel. |  |
| [Download speed boost](#download-speed-boost) | Increases download chunk size to 1 MB and max concurrent requests to 12. |  |
| [Hide typing indicator](#hide-typing-indicator) | Hides your typing indicator from other users in all chats. On Telegram Plus also silences the controller-level sendTyping dispatcher. |  |
| [Remove ads](#remove-ads) | Removes sponsored messages and video ads from all chats and channels. On Telegram Plus also blocks native banner and inline ads. |  |
| [Unlock Premium](#unlock-premium) | Unlocks Telegram Premium features for the current account. |  |
| [Use normal paste](#use-normal-paste) | Skips Telegram's Rich HTML paste handler and falls back to the normal paste path. |  |
| [Voice to music](#voice-to-music) | Plays voice notes in the full music player with seek bar and background playback. |  |

</details>

<details>
<summary>📦 DooFlix&nbsp;&nbsp;•&nbsp;&nbsp;3 patches</summary>
<br>

**🎯 Supported versions:**

| 9.8 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Bypass Protections](#bypass-protections) | Bypasses DNS blocker gate and tamper class detection. |  |
| [Remove Ads](#remove-ads) | Disables AdMob, Unity, IMA SDK, and WebView pre-roll ads in the player. |  |
| [Remove Reward Service](#remove-reward-service) | Removes nodepointer background SDK and bypasses forced update screen. |  |

</details>

<details>
<summary>📦 Amazon Shopping&nbsp;&nbsp;•&nbsp;&nbsp;8 patches</summary>
<br>

**🎯 Supported versions:**

| 32.18.0.100 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Dark mode](#dark-mode) | Force dark mode for Amazon Shopping. | • Dark mode |
| [Disable search suggestions tracking](#disable-search-suggestions-tracking) | Prevents search keypress and focus events from being sent with suggestion requests. |  |
| [Disable video autoplay](#disable-video-autoplay) | Prevents videos from autoplaying in Amazon's in-app WebView pages. |  |
| [Fix Amazon manifest conflicts](#fix-amazon-manifest-conflicts) | Updates shared Amazon permissions so other Amazon apps can coexist. |  |
| [Hide Rufus tab](#hide-rufus-tab) | Removes the Rufus AI assistant tab from Amazon's bottom navigation bar. |  |
| [Open links in browser](#open-links-in-browser) | Opens non-Amazon URLs in the default browser instead of the in-app WebView. |  |
| [Price history charts](#price-history-charts) | Injects Keepa and CamelCamelCamel price history charts on Amazon product pages. | • Chart period<br>• Show period toggle<br>• Toggle periods<br>• Keepa price lines<br>• CamelCamelCamel chart<br>• Hide zero-price gaps<br>• Chart size<br>• Start collapsed |
| [Remove ads](#remove-ads) | Hides sponsored and ad content in Amazon Shopping via CSS injection. |  |

</details>

<details>
<summary>📦 Amazon India&nbsp;&nbsp;•&nbsp;&nbsp;8 patches</summary>
<br>

**🎯 Supported versions:**

| 32.18.0.300 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Dark mode](#dark-mode) | Force dark mode for Amazon Shopping. | • Dark mode |
| [Disable search suggestions tracking](#disable-search-suggestions-tracking) | Prevents search keypress and focus events from being sent with suggestion requests. |  |
| [Disable video autoplay](#disable-video-autoplay) | Prevents videos from autoplaying in Amazon's in-app WebView pages. |  |
| [Fix Amazon manifest conflicts](#fix-amazon-manifest-conflicts) | Updates shared Amazon permissions so other Amazon apps can coexist. |  |
| [Hide Rufus tab](#hide-rufus-tab) | Removes the Rufus AI assistant tab from Amazon's bottom navigation bar. |  |
| [Open links in browser](#open-links-in-browser) | Opens non-Amazon URLs in the default browser instead of the in-app WebView. |  |
| [Price history charts](#price-history-charts) | Injects Keepa and CamelCamelCamel price history charts on Amazon product pages. | • Chart period<br>• Show period toggle<br>• Toggle periods<br>• Keepa price lines<br>• CamelCamelCamel chart<br>• Hide zero-price gaps<br>• Chart size<br>• Start collapsed |
| [Remove ads](#remove-ads) | Hides sponsored and ad content in Amazon Shopping via CSS injection. |  |

</details>

<details>
<summary>📦 Feem&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 6.10.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Disable Ads](#disable-ads) | Disables AdMob interstitial and banner ads. |  |

</details>

<details>
<summary>📦 1.1.1.1&nbsp;&nbsp;•&nbsp;&nbsp;3 patches</summary>
<br>

**🎯 Supported versions:**

| 6.38.9 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Disable Analytics / Telemetry](#disable-analytics-telemetry) | Disables all Cloudflare telemetry by no-oping the analytics bundle builder and the Firebase event dispatchers. |  |
| [Disable SSL Pinning](#disable-ssl-pinning) | Bypasses OkHttp certificate pinning on Cloudflare API calls to allow TLS traffic inspection. |  |
| [Spoof WARP+ Unlimited UI](#spoof-warp-unlimited-ui) | Forces WarpPlusState to UNLIMITED on every AccountData instance by intercepting the primary constructor before the account type field is written. |  |

</details>

<details>
<summary>📦 Reddit&nbsp;&nbsp;•&nbsp;&nbsp;5 patches</summary>
<br>

**🎯 Supported versions:**

| 🧪&nbsp;2026.42.0 | 🧪&nbsp;2026.41.0 | 🧪&nbsp;2026.40.0 | 🧪&nbsp;2026.39.0 | 2026.24.0 | 2026.10.0 |
| :---: | :---: | :---: | :---: | :---: | :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Disable Click Tracking](#disable-click-tracking) | Forces the outbound click-tracking account preference off at the Account deserialization choke point (local; server-side click analytics may still be recorded). Enabled by default. |  |
| [Employee Debug Flags](#employee-debug-flags) | Spoofs is_employee locally at the Account JSON adapter, exposing Reddit's internal employee/debug UI menus (mostly non-functional without the employee backend, and a few may misbehave — enable for exploration only). Off by default. |  |
| [Remove ads](#remove-ads) | Hides promoted posts in feeds and banner ads in comment threads. |  |
| [Unlock Account Entitlements](#unlock-account-entitlements) | Locally flips account-gating flags at the Account JSON adapter: can_create_subreddit, can_edit_name, password_set (kills the SSO 'set password' nag) and has_verified_email. Off by default; server entitlements still rule API actions. |  |
| [Unlock Premium](#unlock-premium) | Flips the local isGold/has_gold_subscription account flags at the JSON adapter to enable Reddit Premium UI (custom icons, premium screens). Server-side perks cannot be unlocked. |  |

</details>

<details>
<summary>📦 CamScanner&nbsp;&nbsp;•&nbsp;&nbsp;2 patches</summary>
<br>

**🎯 Supported versions:**

| 7.24.5.2608200000 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Disable telemetry](#disable-telemetry) | Disables CamScanner's custom telemetry/log-agent system. |  |
| [Unlock Yearly](#unlock-yearly) | Unlocks premium features without login. Note: Login Won't Work |  |

</details>

<details>
<summary>📦 Inure App Manager (GitHub)&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| build107.2.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Inure — Unlock Full Version (GitHub)](#inure-unlock-full-version-github) | Bypasses the 15-day trial gate and unlocks all premium features in Inure App Manager (GitHub). |  |

</details>

<details>
<summary>📦 Life360&nbsp;&nbsp;•&nbsp;&nbsp;2 patches</summary>
<br>

**🎯 Supported versions:**

| 26.31.6 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Material You themed icon](#material-you-themed-icon) | Adds a proper Android adaptive launcher icon and a monochrome Material You themed icon. |  |
| [Unlock Platinum](#unlock-platinum) | Unlocks Life360 Platinum feature in app. |  |

</details>

<details>
<summary>📦 Teams&nbsp;&nbsp;•&nbsp;&nbsp;2 patches</summary>
<br>

**🎯 Supported versions:**

| 1416/1.0.0.2026152302 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Privacy Enhancements](#privacy-enhancements) | Suppresses outbound read receipts and prevents admin quiet-hours policies from overriding your presence status. |  |
| [Unlock Teams](#unlock-teams) | Unlocks Teams Premium features. |  |

</details>

<details>
<summary>📦 Cube Solver&nbsp;&nbsp;•&nbsp;&nbsp;2 patches</summary>
<br>

**🎯 Supported versions:**

| 5.1.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Puzzles Unlock](#puzzles-unlock) | Unlocks all puzzle designs including kilominx and ad-gated variants. |  |
| [Remove Ads](#remove-ads) | Removes advertisements and disables crash/analytics telemetry. |  |

</details>

<details>
<summary>📦 Toomics&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.6.9 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove ADS](#remove-ads) | Remove in-app ads |  |

</details>

<details>
<summary>📦 Flud&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.1.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove Ads](#remove-ads) | Removes all ads in app |  |

</details>

<details>
<summary>📦 m-Indicator&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 18.0.365 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove Ads](#remove-ads) | Removes interstitial and exit native ads from m-Indicator. |  |

</details>

<details>
<summary>📦 Opera News&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 14.4.2254.84848 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove Ads](#remove-ads) | Blocks all ad display across Opera News's five ad networks and all mediation layers (AdsFacade, AppLovin MAX, TopOn, MCSDK, SmartDigiMkt). |  |

</details>

<details>
<summary>📦 Oxygen Updater&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 7.1.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove Ads](#remove-ads) | Unlocks the ad-free experience by spoofing the purchase state as acknowledged. |  |

</details>

<details>
<summary>📦 PicsArt&nbsp;&nbsp;•&nbsp;&nbsp;3 patches</summary>
<br>

**🎯 Supported versions:**

| 30.7.8 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove Ads](#remove-ads) | Disables PicsArt banner and interstitial ads by forcing the central AdsManager gate to ads-off. |  |
| [Remove Watermark](#remove-watermark) | Removes the PicsArt watermark from exported photos and videos. |  |
| [Unlock Premium](#unlock-premium) | Unlocks PicsArt premium locally: forces the subscription state to subscribed at the data-class root so tools/effects unlock and upgrade prompts are skipped. |  |

</details>

<details>
<summary>📦 qBitConnect&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.0.6 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove Ads](#remove-ads) | Unlocks the Remove Ads purchase in qBitConnect by injecting IAP ownership flags into SharedPreferences before Flutter reads them. |  |

</details>

<details>
<summary>📦 Send Files To TV&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.4.22 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove Ads](#remove-ads) | Removes ads. |  |

</details>

<details>
<summary>📦 TorrDroid&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.0.3 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove Ads](#remove-ads) | Removes ads from TorrDroid. |  |

</details>

<details>
<summary>📦 VIZ Manga&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.14.6 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove Ads](#remove-ads) | Remove in-app ads. |  |

</details>

<details>
<summary>📦 Tracker Detect&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove Sound Delay](#remove-sound-delay) | Removes the 10-minute waiting period before playing a sound on a detected tracker. |  |

</details>

<details>
<summary>📦 Canva&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.377.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove Watermark](#remove-watermark) | Removes watermarks from Canva exports and previews. |  |

</details>

<details>
<summary>📦 AIDA64&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.22 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove ads](#remove-ads) | Stubs all ad loading paths: banner/interstitial loaders, billing callbacks, and ad SDK init. |  |

</details>

<details>
<summary>📦 Block Puzzle&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 6.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove ads](#remove-ads) | Disables Block Puzzle AdMob initialization, banner, and interstitial ads. |  |

</details>

<details>
<summary>📦 LiveScore&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 10.3.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Remove ads](#remove-ads) | Disables LiveScore banner, native, and interstitial ad requests. |  |

</details>

<details>
<summary>📦 Server Auditor&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 7.11.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Server Auditor Premium](#server-auditor-premium) | Unlocks Pro features by forcing the UserType mapper to always return UserType$Pro. |  |

</details>

<details>
<summary>📦 FlightAware&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.16.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Ad-Free](#unlock-ad-free) | Forces FlightAware ad-free subscribed state. |  |

</details>

<details>
<summary>📦 Speedtest&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 7.1.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Ad-Free](#unlock-ad-free) | Removes ads and unlocks ad-free status in Speedtest by Ookla. |  |

</details>

<details>
<summary>📦 nzb360&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 25.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock All Access](#unlock-all-access) | Unlocks All access in Nzb360. |  |

</details>

<details>
<summary>📦 Flightradar24&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 11.12.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Business Premium](#unlock-business-premium) | Unlocks Business-tier features in Flightradar24: ad-free experience, weather layers, ATC routes, 3D view, flight history playback, and unlimited saved locations. |  |

</details>

<details>
<summary>📦 Blurams&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.1049.4.921 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Cloud Service](#unlock-cloud-service) | Unlocks BluramsGuard cloud storage, AI detection, and playback features. |  |

</details>

<details>
<summary>📦 Citymapper&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 11.60 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Club](#unlock-club) | Unlocks Citymapper Club Membership. Note: requires a manual purchase attempt inside the app. |  |

</details>

<details>
<summary>📦 MANGA Plus by SHUEISHA&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.7.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Deluxe](#unlock-deluxe) | Unlocks the Deluxe subscription. |  |

</details>

<details>
<summary>📦 Greenify&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.1.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Donation](#unlock-donation) | Unlocks all premium donation features in Greenify. |  |

</details>

<details>
<summary>📦 Scoopz&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.36.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Drama Episodes](#unlock-drama-episodes) | Bypasses the IAA (ad-watch-to-unlock) episode gate for drama mini-series. |  |

</details>

<details>
<summary>📦 JEFIT&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 17.4.5 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Elite](#unlock-elite) | Unlocks JEFIT Elite features in app. |  |

</details>

<details>
<summary>📦 MigraConnect&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.8.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Enterprise](#unlock-enterprise) | Unlocks Enterprise features in app. |  |

</details>

<details>
<summary>📦 Excel&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 16.0.20228.20090 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Excel](#unlock-excel) | Removes login requirement, unlocks premium, blocks ads, bypasses signature and code transparency checks. |  |

</details>

<details>
<summary>📦 Inure App Manager&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| build107.2.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Full Version](#unlock-full-version) | Bypasses the 15-day trial gate and unlocks all premium features in Inure App Manager. |  |

</details>

<details>
<summary>📦 Kahoot!&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 6.6.7 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Gold](#unlock-gold) | Unlocks Kahoot! Plus Gold features in app. |  |

</details>

<details>
<summary>📦 BubbleUPnP&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.6.7.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Licence](#unlock-licence) | Unlocks BubbleUPnP licence by forcing the licence setter to always write true. |  |

</details>

<details>
<summary>📦 BlockerHero&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.5.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Lifetime](#unlock-lifetime) | Unlocks lifetime subscription features in BlockerHero. |  |

</details>

<details>
<summary>📦 Proxyman&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.21.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Lifetime](#unlock-lifetime) | Unlocks all Lifetime features in Proxyman. |  |

</details>

<details>
<summary>📦 AdGuard&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.14.68 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Lifetime Premium](#unlock-lifetime-premium) | Unlocks all features locked behind the subscription paywall. |  |

</details>

<details>
<summary>📦 DramaBox&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.8.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Membership](#unlock-membership) | Unlocks DramaBox VIP membershipNote: Use apk from Uptodown |  |

</details>

<details>
<summary>📦 Moovit&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.197.1.1801 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Moovit+](#unlock-moovit) | Unlocks Moovit+ premium features, removes ads, and suppresses all upgrade paywalls and UI. |  |

</details>

<details>
<summary>📦 Pixel Habit Tracker&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.5.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock PRO](#unlock-pro) | Unlocks all PRO features by permanently reporting a purchased state. |  |

</details>

<details>
<summary>📦 Pocket Casts&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 8.16 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Patron](#unlock-patron) | Unlocks Pocket Casts Patron yearly feature checks. |  |

</details>

<details>
<summary>📦 Clue Period & Cycle Tracker&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 273.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Plus](#unlock-plus) | Forces Clue Plus subscription active, unlocking all premium features. |  |

</details>

<details>
<summary>📦 SpotAngels&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 15.2.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Plus](#unlock-plus) | Unlocks all SpotAngels Plus features in app |  |

</details>

<details>
<summary>📦 Sticker.ly&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.40.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Plus](#unlock-plus) | Unlocks Sticker.ly Plus subscription. Note: For Facebook Login, uninstall the Facebook app first. |  |

</details>

<details>
<summary>📦 Subway Now&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.2.10 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Plus](#unlock-plus) | Unlocks Subway Now Plus. |  |

</details>

<details>
<summary>📦 AAEnabler&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| v1.0.14 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks premium installation features by bypassing the Firestore license check. |  |

</details>

<details>
<summary>📦 AccuBattery&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.1.8 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks AccuBattery Pro by bypassing server offer validity, the Google Play purchase gate, and all UI premium banners. |  |

</details>

<details>
<summary>📦 Ace Ex File Manager&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.6.0.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks premium features in app. |  |

</details>

<details>
<summary>📦 Adobe Scan&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 26.08.01 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium scanning and PDF tools in Adobe Scan. |  |

</details>

<details>
<summary>📦 AiScore&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.2.7 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks AiScore Premium Features in app. |  |

</details>

<details>
<summary>📦 All Reader&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.2.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks All Reader premium features and removes ads. |  |

</details>

<details>
<summary>📦 Ampere&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| v4.37.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks the Remove Ads purchase in Ampere by bypassing the isProVersion getter and purchase verifier. |  |

</details>

<details>
<summary>📦 AndroPods&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.5.30 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks AndroPods Pro: voice call integration, assistant control, ear detection auto-pause/resume, and all premium preferences. |  |

</details>

<details>
<summary>📦 AnExplorer&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 6.0.6 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks AnExplorer Pro: hides paywall and removes all purchase gates. |  |

</details>

<details>
<summary>📦 Anime Depth Wallpapers&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.1.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium wallpapers. |  |

</details>

<details>
<summary>📦 Athena&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.80 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium features in Athena by making Settings.getPremiumUnlocked() always return true. |  |

</details>

<details>
<summary>📦 Automate&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.53.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Removes the 30 running statement limit and unlocks Automate premium features. |  |

</details>

<details>
<summary>📦 Awake&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.10.3 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium features in Awake by bypassing the RC entitlement check chain and the Pairip Play Licensing verification. |  |

</details>

<details>
<summary>📦 Battery Guru&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.5.0.8 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks premium and marks the yearly plan as purchased. |  |

</details>

<details>
<summary>📦 BatteryPods&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 7.52 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks BatteryPods Pro: removes all advertisements and enables premium features including all widget themes and device customization options. |  |

</details>

<details>
<summary>📦 Bluetooth Keyboard & Mouse&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 6.23.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium features including fullscreen mode and removes the Upgrade navigation item. |  |

</details>

<details>
<summary>📦 Blocking Sites&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.0.19 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks premium features in Blocking Sites. |  |

</details>

<details>
<summary>📦 BlurWall&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.0.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlock Premium Features in app. |  |

</details>

<details>
<summary>📦 BoldVoice&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.6.6 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks BoldVoice premium subscription and removes upsell nags. |  |

</details>

<details>
<summary>📦 calimoto&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2026.10.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Calimoto LIFETIME membership by spoofing the membership getter. |  |

</details>

<details>
<summary>📦 Cube ACR&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.4.281 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Premium Features In the App. |  |

</details>

<details>
<summary>📦 Calm&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 6.102 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Calm Premium: removes all subscription gates, upsell banners, video session locks, and content locks. |  |

</details>

<details>
<summary>📦 Calory&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.8.7 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Calory Pro and removes ads. |  |

</details>

<details>
<summary>📦 Carbon&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.76.5966 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Carbon premium subscription. |  |

</details>

<details>
<summary>📦 Cast to TV&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.5.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Cast to TV - XCast premium by forcing subscription and pro gates to return true. |  |

</details>

<details>
<summary>📦 Charge Meter&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.0.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Charge Meter premium features. |  |

</details>

<details>
<summary>📦 ColorNote&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.8.8 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks ColorNote premium by forcing license validity and subscription checks to return true. |  |

</details>

<details>
<summary>📦 Countdown Widget&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.2.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium features in Countdown Widget |  |

</details>

<details>
<summary>📦 CPU-Z&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.60 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks premium features in app. |  |

</details>

<details>
<summary>📦 Crime Radar&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 26.41.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks CrimeRadar premium subscription, raises followed locations limit, removes ads, and disables PairIP licence checks. |  |

</details>

<details>
<summary>📦 Dailyhunt&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 34.0.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks premium features after login. |  |

</details>

<details>
<summary>📦 Depth Live Wallpaper&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.1.07 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium wallpapers. |  |

</details>

<details>
<summary>📦 Zutobi&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.5.78 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Driver's Ed premium features by patching the Flutter subscription gate. |  |

</details>

<details>
<summary>📦 Electron&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.0.3 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Electron premium features |  |

</details>

<details>
<summary>📦 File Manager&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.8.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all File Manager premium features by bypassing the RSA license token verification. |  |

</details>

<details>
<summary>📦 Fitbod&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 8.33.0-0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all Fitbod premium features. |  |

</details>

<details>
<summary>📦 Fitia&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 26.0.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all Fitia premium features by permanently reporting an active subscription. |  |

</details>

<details>
<summary>📦 Fuelio&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 10.3.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Fuelio Premium, restores Google Maps, and suppresses the Limited Promo paywall banner for unlocked users. |  |

</details>

<details>
<summary>📦 Historical Calendar&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 7.6.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium features in Historical Calendar by forcing the isPremium gate to return true. |  |

</details>

<details>
<summary>📦 Hola VPN Proxy Plus&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| AARCH64_1.248.400 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) |  |  |

</details>

<details>
<summary>📦 Image & Video Date Fixer&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.7.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium features in Image & Video Date Fixer. |  |

</details>

<details>
<summary>📦 Clickmate&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 7.1.6 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks premium features in Clickmate by bypassing the purchase check. |  |

</details>

<details>
<summary>📦 KineMaster&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 8.1.13.36552.GP |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlock Premium features after login. |  |

</details>

<details>
<summary>📦 komoot&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2026.37.5 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks premium features and all map packs. |  |

</details>

<details>
<summary>📦 Lark Player&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2026.12.5 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks premium features in app. |  |

</details>

<details>
<summary>📦 Lawfully&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 6.8.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Premium Features in app. |  |

</details>

<details>
<summary>📦 Mapy.com&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 26.8.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Premium features in app after login. |  |

</details>

<details>
<summary>📦 MaterialPods&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 6.72 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all pro features. |  |

</details>

<details>
<summary>📦 meteoblue Weather&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| Cirrus Uncinus 3.0.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all meteoblue Weather premium features by making the billing repository always report an active purchase. |  |

</details>

<details>
<summary>📦 Minimal Widgets&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.1.04 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlock all premium widgets. |  |

</details>

<details>
<summary>📦 Beta Maniac&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 0.11.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks premium in Beta by Mirko by disabling the ads gate and PairIP license checks. |  |

</details>

<details>
<summary>📦 MobiOffice&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 16.5.60515 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks MobiOffice premium and removes ads. |  |

</details>

<details>
<summary>📦 Monet&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| v1.0.76 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all Monet Launcher premium features by forcing the billing cache to always report premium as active. |  |

</details>

<details>
<summary>📦 MyRadar&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 8.73.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks MyRadar's yearly premium features |  |

</details>

<details>
<summary>📦 NetMonster&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.0.5 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium features. |  |

</details>

<details>
<summary>📦 NewsBreak&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 26.41.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks NewsBreak Premium: ad-free reading, premium article access, and Reading Mode. |  |

</details>

<details>
<summary>📦 NewsBreak Lite&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 26.34.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks NewsBreak Lite Premium: ad-free reading, premium article access, and Reading Mode. |  |

</details>

<details>
<summary>📦 Ninja VPN&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.4.7 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Ninja VPN premium. |  |

</details>

<details>
<summary>📦 OBD Android&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.9 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium features including advanced diagnostics, live sensor data, freeze frame, and removes the daily usage quota. |  |

</details>

<details>
<summary>📦 Parcels — Package Tracker&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.0.11 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlock premium features. |  |

</details>

<details>
<summary>📦 Park4Night&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 7.1.62 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Park4Night premium (Pro) access, removing all feature gates for offline maps, advanced filters, and publisher content. |  |

</details>

<details>
<summary>📦 PC Remote&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 8.3.5 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks premium features after login. |  |

</details>

<details>
<summary>📦 Photo Editor&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 14.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all Photo Editor premium features and removes ads by bypassing the software license cache check. |  |

</details>

<details>
<summary>📦 Pialytic&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.3.5 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Bypasses PairIP DRM license check, removes all paywalls, and unlocks all premium features including cloud sync and remote access. |  |

</details>

<details>
<summary>📦 Picture Mushroom&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.9.31 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Picture Mushroom premium features. |  |

</details>

<details>
<summary>📦 PictureThis&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.36.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks PictureThis premium features. |  |

</details>

<details>
<summary>📦 pillo&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 0.6.24 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium features and removes ads by overriding the subscription state setters in pillo. |  |

</details>

<details>
<summary>📦 PodsLink&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.4.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks lifetime pro by bypassing all entitlement checks and poisoning the account cache. |  |

</details>

<details>
<summary>📦 Psiphon Pro&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 486 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Forces the subscription gate to report an unlimited subscription, removing ads and the upgrade prompt. Constructs a minimal fake Purchase to prevent NPE/IOOB in call sites that dereference getProducts().get(0). |  |

</details>

<details>
<summary>📦 Rainbow Weather&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.24.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all Rainbow Weather premium features by forcing isPremium=true in the Adapty DataStore write. |  |

</details>

<details>
<summary>📦 RecipeBro&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.7.21 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks RecipeBro premium by patching both CustomerInfo and FeatureFlagResponse premium gates. |  |

</details>

<details>
<summary>📦 re-Link&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.0.13 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium features in re-Link by forcing the license StateFlow to always emit a Licensed state and the sync purchase check to always return true. |  |

</details>

<details>
<summary>📦 Rename & Organize&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 8.30.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium features in Rename & Organize. |  |

</details>

<details>
<summary>📦 Rocket Money&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 13.15.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Rocket Money Premium Features. |  |

</details>

<details>
<summary>📦 RS File Manager&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.3.0.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks premium features in app. |  |

</details>

<details>
<summary>📦 SAI Split APKs Installer&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.4.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks SAI Split APKs Installer premium by bypassing RevenueCat entitlement checks using stable SDK-anchored fingerprints. |  |

</details>

<details>
<summary>📦 SCRL&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.31 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium feature in app. |  |

</details>

<details>
<summary>📦 SHAREit Premium&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.1.98 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks SHAREit Premium and bypasses APK signature tamper check. |  |

</details>

<details>
<summary>📦 Slopes&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2026.16 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium features. |  |

</details>

<details>
<summary>📦 Snipd&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.3.11 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all Premium features in Snipd: AI Podcast Player by spoofing the RevenueCat CustomerInfo. |  |

</details>

<details>
<summary>📦 Snow-Forecast.com&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 8.0.8 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Premium features. |  |

</details>

<details>
<summary>📦 Social Gamebox&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.4.3 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Social Gamebox premium features. |  |

</details>

<details>
<summary>📦 SocialLite&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.0.0.59 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Bypasses PairIP DRM and unlocks all SocialLite Pro features. |  |

</details>

<details>
<summary>📦 Sticker Maker&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.0.12-7 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Sticker Maker premium and ad-free checks. |  |

</details>

<details>
<summary>📦 Strava&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 480.15 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Strava Premium features. Also re-enables password login after OTP. |  |

</details>

<details>
<summary>📦 Super File&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.5.6.3 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks premium and lifetime features in Super File. |  |

</details>

<details>
<summary>📦 Tag Tracker&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.3.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Tag Tracker PRO: unlimited trackers, advanced detection, full history, and ad-free experience. |  |

</details>

<details>
<summary>📦 The Athletic&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 13.153.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Bypasses The Athletic paywall and removes all ads. |  |

</details>

<details>
<summary>📦 The Weather Channel&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 16.25.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks The Weather Channel's Premium and Premium Pro subscription tiers. Enables the ad-free experience, extended 15-day hourly forecast, real-feel temperature, air quality index, minute-by-minute precipitation, severe weather notifications, and radar overlays gated behind the subscription paywall. |  |

</details>

<details>
<summary>📦 Today Weather&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.5.0-6 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium features. |  |

</details>

<details>
<summary>📦 TomTom GO&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.6.320 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks TomTom GO premium features for the selected vehicle type. | • Vehicle type |

</details>

<details>
<summary>📦 HD UHD Live Wallpapers&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 6.1.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium wallpapers and removes interstitial ads permanently. |  |

</details>

<details>
<summary>📦 Toxly&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.20.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Toxly Premium by bypassing the Pairip license check and activating the premium billing state at repository level. |  |

</details>

<details>
<summary>📦 Unimote&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.8.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Premium Features In the App. |  |

</details>

<details>
<summary>📦 VRadio&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.9.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all VRadio premium features by bypassing the SharedPreferences purchase gate. |  |

</details>

<details>
<summary>📦 Vyxel Apps&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.0.7 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium themes (Liquid Glass, Neon Punk, Cyberpunk) by bypassing the Gumroad license key verification. |  |

</details>

<details>
<summary>📦 Wallverse&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks lifetime Premium in Wallverse. |  |

</details>

<details>
<summary>📦 Wavve Boating&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.7.8 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all Wavve Boating GPS premium features: charts, weather, tide data, and removes subscription paywall. |  |

</details>

<details>
<summary>📦 Widget 2026&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 85.1.4 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks all premium widgets, themes, and features in Widget 2026 by bypassing the PremiumHelper SDK subscription check at both the public API (d.b()) and SharedPreferences root (yd/e.j()). |  |

</details>

<details>
<summary>📦 Windscribe VPN&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.3.2360 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Windscribe premium account. |  |

</details>

<details>
<summary>📦 Windy&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 51.0.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium](#unlock-premium) | Unlocks Windy Pro features by patching the versioned JS bundle. Sets subscription store default to 'premium' (P1), forces gr=true (P2) and hasAny()=true (P3) at module load. Prevents cu() from clearing the subscription store (P4) and flips its body class call from remove to add (P5), ensuring the 'subs-premium' CSS class persists on <body> even when the server reports no active subscription. Unlocks higher tile zoom, 1-hour forecast steps, premium minifest API params, the premium calendar view, and all premium UI. |  |

</details>

<details>
<summary>📦 AccuWeather&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 21.1.15-3-rc |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Premium+](#unlock-premium) | Unlocks AccuWeather's Premium+ subscription tier without a Play Store purchase. Enables the full 15-day and hourly forecast detail, MinuteCast extended precision, air quality and health indexes, real-feel temperature, severe weather notifications, and widget customisation. |  |

</details>

<details>
<summary>📦 Nova Launcher&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 8.8.8 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Prime](#unlock-prime) | Unlocks Nova Launcher Prime by bypassing the static isPrime gate, forcing the runtime prime state to true on startup, and bypassing the subscription-active verification check. |  |

</details>

<details>
<summary>📦 1Tap Cleaner&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.22 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks App Cache Cleaner Pro and removes ads by bypassing Pairip LVL, signature checks, self-destruct, and all upgrade dialogs. |  |

</details>

<details>
<summary>📦 Adobe Acrobat&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 26.7.0.47169 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks all Acrobat Pro and Studio tools without a subscription. |  |

</details>

<details>
<summary>📦 Auto Cursor&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.11.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks Auto Cursor Pro by bypassing the local purchase state check. |  |

</details>

<details>
<summary>📦 Aviate&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.1.0-beta.1 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks Aviate Pro and Lifetime Pro by patching the Hermes JS subscription gate. |  |

</details>

<details>
<summary>📦 Bluetooth Volume Manager&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.5.0-rc0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks the Pro upgrade in Bluetooth Volume Manager by forcing isPro=true. |  |

</details>

<details>
<summary>📦 Box Box&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.4.17 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks Box Box Pro |  |

</details>

<details>
<summary>📦 CAPod&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.2.5-rc0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks the Pro. |  |

</details>

<details>
<summary>📦 Case Tracker&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.6.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks all premium features in Case Tracker — Immigration. |  |

</details>

<details>
<summary>📦 Cashew&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 6.7.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlock Pro Features in Cashew App |  |

</details>

<details>
<summary>📦 Citizen&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 0.1307.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks all Citizen Plus/Protect features: Safety Network, Safety Center, Zones, Live Agent, Offender alerts, Clarity crime map, incident video, and more. |  |

</details>

<details>
<summary>📦 Hibernator&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.57.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks all pro features in Hibernator. |  |

</details>

<details>
<summary>📦 Hydro Coach&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.1.13 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks all pro features and removes ads in Hydro Coach by forcing the master premium gate, ads gate, and no-ads SKU check to return true/false respectively. |  |

</details>

<details>
<summary>📦 Inmigreat&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.3.87 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlock Pro Features in app. |  |

</details>

<details>
<summary>📦 KillApps&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.58.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks all pro features in KillApps. |  |

</details>

<details>
<summary>📦 MacroDroid&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.66.9 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks Pro for MacroDroid - Device Automation. |  |

</details>

<details>
<summary>📦 MEGA&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 16.12(262370820)(dcdf0a7f27) |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks all Pro features. |  |

</details>

<details>
<summary>📦 MikroTik Network Tools&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 279 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Bypasses the Google Play Billing purchase check, unlocking all pro features. |  |

</details>

<details>
<summary>📦 ML Manager&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks all pro features in ML Manager. |  |

</details>

<details>
<summary>📦 Permission Pilot&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.2.2-rc0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks Permission Pilot Pro by forcing isPro=true in the billing Info object. |  |

</details>

<details>
<summary>📦 NetGuard&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.337 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks all pro features in NetGuard. |  |

</details>

<details>
<summary>📦 Network Guru&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlock Pro features. |  |

</details>

<details>
<summary>📦 Octi&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.3.0-rc0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks the Pro upgrade in Octi. |  |

</details>

<details>
<summary>📦 Octopi Launcher&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.88 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks Octopi Launcher Pro by returning true from the isPro LiveData getter, bypassing all pro feature gates without modifying billing or database logic. |  |

</details>

<details>
<summary>📦 Parallel Space Pro&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.0.9162 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks Parallel Space Pro subscription features by bypassing all Pro status checks. |  |

</details>

<details>
<summary>📦 Police Scanner&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.29.0-260420093 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks premium features in app. |  |

</details>

<details>
<summary>📦 PortDroid&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.0.7 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks PortDroid Pro features by bypassing the Google Play Billing check, the SharedPreferences pro gate, and the signature tamper check. |  |

</details>

<details>
<summary>📦 RAR&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 7.23.build134 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Removes ads and unlocks the no-ads subscription in RAR. |  |

</details>

<details>
<summary>📦 SD Maid SE&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.0.3-rc0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks SD Maid SE Pro features. |  |

</details>

<details>
<summary>📦 App Permission Manager&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.4.6.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks all Pro features in app. |  |

</details>

<details>
<summary>📦 Splitwise&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 26.7.3 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks Splitwise Pro features (charts, receipt scanning, itemization, default splits, transaction import), forces Person.isPro()=true, and suppresses all upsell banners and paywall prompts in the Account, Activity, and Balances tabs. |  |

</details>

<details>
<summary>📦 Torrent Search Revolution V2&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.3.3 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks all pro features and removes ads . |  |

</details>

<details>
<summary>📦 TrackChecker Mobile&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.29.3 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks Pro/No Ads feature in app |  |

</details>

<details>
<summary>📦 TurboScan&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.7.3 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlock Pro features in app. |  |

</details>

<details>
<summary>📦 UbikiTouch&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.17.10 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks UbikiTouch Pro features by overriding the premium state getter. |  |

</details>

<details>
<summary>📦 UDisc&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 24.3.2 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Unlocks UDisc Pro subscription. |  |

</details>

<details>
<summary>📦 USB Hotspot&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.7 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Pro](#unlock-pro) | Bypasses the Google Play Billing premium check, unlocking pro features. |  |

</details>

<details>
<summary>📦 WolframAlpha&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.0.8.20260601651 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Professional](#unlock-professional) | Unlocks Professional features inapp. |  |

</details>

<details>
<summary>📦 Transit&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 6.3.5 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Royale](#unlock-royale) | Unlocks Transit Royale Membership. |  |

</details>

<details>
<summary>📦 SPIN&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 70.3.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock SPIN Plus](#unlock-spin-plus) | Unlocks SPIN Plus |  |

</details>

<details>
<summary>📦 BuzzCast&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.2.91 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock SVIP](#unlock-svip) | Unlocks SViP features in app. |  |

</details>

<details>
<summary>📦 Stargazing Hub&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.5.3 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Subscription](#unlock-subscription) | Unlocks all subscription features in TWT App. |  |

</details>

<details>
<summary>📦 MyAnimeList&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.3.16 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Supporter](#unlock-supporter) | Spoofs MAL supporter status to suppress all banner, list, and search ads. |  |

</details>

<details>
<summary>📦 Uptodown App Store&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 7.37 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Turbo](#unlock-turbo) | Unlocks Turbo subscription and bypasses cert/debug integrity checks. |  |

</details>

<details>
<summary>📦 APKMirror Installer&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.0.3 (41-d04e542) |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Ultimate](#unlock-ultimate) | Unlocks Ultimate Ad-Free + Android TV. |  |

</details>

<details>
<summary>📦 Malwarebytes Mobile Security&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.27.0+564 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Ultimate](#unlock-ultimate) | Unlocks all Malwarebytes Ultimate features via enum singleton and feature gate patches. |  |

</details>

<details>
<summary>📦 Genius Scan&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 7.41.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Ultra](#unlock-ultra) | Unlocks Ultra features in app. |  |

</details>

<details>
<summary>📦 Proton Pass&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.41.3 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Unlimited Plan](#unlock-unlimited-plan) | Forces Proton Pass Plus plan with all limits removed and paid features unlocked. |  |

</details>

<details>
<summary>📦 AppLock Watcher&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 6.3.3 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock VIP](#unlock-vip) | Unlocks all VIP features by bypassing the subscription status checks for all billing paths. |  |

</details>

<details>
<summary>📦 Block Blast!&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 10.4.5 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock VIP](#unlock-vip) | Unlock ViP features in app. |  |

</details>

<details>
<summary>📦 HTTP Sniffer&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.5.0-ad_mob |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock VIP](#unlock-vip) | Forces permanent professional VIP tier, removes ads and upgrade popups, bypasses PairIP. |  |

</details>

<details>
<summary>📦 Money Manager&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.9.9 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock VIP](#unlock-vip) | Unlocks VIP and shows Life Member status for Money Manager - Budget & Meow. |  |

</details>

<details>
<summary>📦 PLAYit&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.7.50.12 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock VIP](#unlock-vip) | Unlock VIP subscription in app. |  |

</details>

<details>
<summary>📦 Yatri&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.0.6 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock VIP](#unlock-vip) | Unlocks Yatri VIP by forcing active plan status and spoofing active plan DB query. |  |

</details>

<details>
<summary>📦 ES File Explorer&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 4.4.3.7 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock VIP Lifetime](#unlock-vip-lifetime) | Unlocks VIP lifetime features in ES File Explorer Phone and TV. |  |

</details>

<details>
<summary>📦 Proton VPN&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.19.78.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock VPN Plus](#unlock-vpn-plus) | Injects max tier (3=PMTeam) into VpnUser at construction for all UI unlocks, while routing connections through free servers for server-side compatibility. Phone and TV |  |

</details>

<details>
<summary>📦 Word&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 16.0.20228.20090 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock Word](#unlock-word) | Removes login requirement, unlocks premium, blocks ads, bypasses signature and code transparency checks. |  |

</details>

<details>
<summary>📦 Weawow&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 7.1.9 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock donation](#unlock-donation) | Forces h0() to return "yes" so donate dialog never shows and providers unlock. |  |

</details>

<details>
<summary>📦 AmoledPix&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 7.3 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock premium](#unlock-premium) | Unlocks AmoledPix premium features and disables ads. |  |

</details>

<details>
<summary>📦 Lose Weight App for Women&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.4.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock premium](#unlock-premium) | Unlocks all premium features across all Leap Fitness Group apps by overriding the IapSp isFree checks. |  |

</details>

<details>
<summary>📦 Height Increase&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.1.17 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock premium](#unlock-premium) | Unlocks all premium features across all Leap Fitness Group apps by overriding the IapSp isFree checks. |  |

</details>

<details>
<summary>📦 Home Workout&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 1.7.9 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock premium](#unlock-premium) | Unlocks all premium features across all Leap Fitness Group apps by overriding the IapSp isFree checks. |  |

</details>

<details>
<summary>📦 Women Workout&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 2.3.5 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock premium](#unlock-premium) | Unlocks all premium features across all Leap Fitness Group apps by overriding the IapSp isFree checks. |  |

</details>

<details>
<summary>📦 NAVITIME&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 12.2.5 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock premium](#unlock-premium) | Unlocks NAVITIME Japan Travel Premium features in app |  |

</details>

<details>
<summary>📦 Pocket Bard&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 3.1.17 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock premium](#unlock-premium) | Unlock Premium features in app |  |

</details>

<details>
<summary>📦 KineStop&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 5.6 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock pro](#unlock-pro) | Unlocks all pro features. |  |

</details>

<details>
<summary>📦 NYT Games&nbsp;&nbsp;•&nbsp;&nbsp;1 patch</summary>
<br>

**🎯 Supported versions:**

| 6.41.0 |
| :---: |

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Unlock subscription](#unlock-subscription) | Unlocks subscription in app |  |

</details>

<details>
<summary>🌐 Universal&nbsp;&nbsp;•&nbsp;&nbsp;7 patches</summary>
<br>

| 💊&nbsp;Patch | 📜&nbsp;Description | ⚙️&nbsp;Options |
|----------|----------------|-----------|
| [Disable PairIP license check](#disable-pairip-license-check) | Disables PairIP license verification, VM checks, and repeated background checks. |  |
| [Fix Firebase after re-signing](#fix-firebase-after-re-signing) | Fixes Firebase services (push notifications, Remote Config, Firebase Auth) that break after Morphe re-signs the app with a different certificate.<br><br>Apply with Original app certificate patch — no other config needed. |  |
| [GmsCore support (MicroG)](#gmscore-support-microg) | Routes Google Play Services calls through MicroG instead of real GPS.<br><br>Works for: Google apps (YouTube, Maps, News, Photos) and third-party apps using classic Google Sign-In (Android 13 and below).<br><br>Does not work for: Android 14+ Credential Manager sign-in (most modern third-party apps), Play Integrity / SafetyNet checks, or apps with custom auth.<br><br>Requires MicroG RE installed. Apply with Original app certificate patch. | • MicroG package name<br>• Main activity class (optional)<br>• Custom package name (optional) |
| [Provide Original app certificate](#provide-original-app-certificate) | Automatically reads the signing certificate from the APK you are patching — no original app installed or file provided needed. Only fill the options below if you are patching an APK that was already re-signed (e.g. a previously patched build): in that case point to the original APK file, or enter the certificate manually. | • Path to original APK (if uninstalled)<br>• Certificate SHA-1 (manual)<br>• Certificate SHA-256 (manual)<br>• Certificate Base64 DER (manual) |
| [Spoof Widevine / DRM level](#spoof-widevine-drm-level) | Reports Widevine L1 (hardware DRM) to apps that check DRM level locally.<br><br>Useful for apps that refuse to play HD/4K content on L3 devices or after re-signing.<br><br>Does not bypass server-side DRM - Netflix, Disney+ and similar are not affected. | • Widevine security level to report<br>• HDCP level to report |
| [Spoof app signature](#spoof-app-signature) | Makes the app think its signing certificate is unchanged after Morphe re-signs it.<br><br>Useful when an app crashes or shows a tamper warning because it checks its own certificate.<br><br>Does not bypass Play Integrity / SafetyNet hardware attestation.<br><br>Apply with Original app certificate patch. | • Package name override (optional) |
| [Spoof install source](#spoof-install-source) | Makes the app think it was installed from a specific store (default: Google Play).<br><br>Useful when an app blocks features or shows errors because it detects it was not installed from the Play Store.<br><br>Only affects what the app itself sees - does not change the real system install record. | • Store to impersonate |

</details>

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
