package app.template.patches.nothingwidgets.universal

import app.morphe.patcher.patch.resourcePatch
import app.template.patches.shared.Constants.NOTHING_WIDGETS_COMPATIBILITY
import org.w3c.dom.Element

/**
 * Makes Nothing Widgets run on any Android ROM (ColorOS, realme UI, One UI, ...).
 *
 * Ground truth from the decoded 3.4.1 (vc 3040101) build:
 *  - Install filter: the manifest declares
 *      <uses-feature android:name="com.nothing.feature.ntwidget.V1_2"/>
 *    (implicitly required) — used by Google Play / APK-bundle installers to
 *    hide the app from non-Nothing devices. Setting android:required="false"
 *    lifts the store-side filter.
 *  - Widget data providers: every hearthstone ContentProvider is declared
 *    android:exported="true", and the sensitive ones carry
 *    android:permission="com.nothing.permission.BIND_CARD_SERVICE" — a
 *    signature-level permission only Nothing-key-signed components can hold.
 *    On any other ROM no app can acquire it, so card data is unreachable.
 *    Removing the permission attribute leaves the providers world-readable;
 *    their payloads are display-only widget state (user-chosen photos, clock
 *    faces, battery %) — verified, no credential-bearing endpoints.
 *  - No launcher activity: every Activity's intent-filter only listens for
 *    com.nothing.action.APPWIDGET_CONFIGURE (fired by Nothing Launcher).
 *    Adding MAIN+LAUNCHER to QuickLookSettingsActivity gives the app a
 *    regular drawer icon so its settings can be opened on any ROM.
 *
 * Scope/honesty: the widgets render inside Nothing Launcher's card surface;
 * generic launchers (realme UI Launcher etc.) cannot host Nothing cards.
 * This patch makes the APP install and run everywhere; widget hosting still
 * requires Nothing Launcher (itself installable on ColorOS) or a card-client.
 */
@Suppress("unused")
val nothingWidgetsUniversalPatch = resourcePatch(
    name = "Universal Android compatibility",
    description = "Lets Nothing Widgets install & run on non-Nothing ROMs (ColorOS, realme UI, ...): " +
        "lifts the Nothing-OS feature gate, un-locks widget providers from the Nothing-launcher " +
        "signature permission, and adds a launcher icon.",
    default = true,
) {
    compatibleWith(NOTHING_WIDGETS_COMPATIBILITY)

    execute {
        document("AndroidManifest.xml").use { document ->
            // 1 - Nothing-OS feature gate: make it non-required.
            val features = document.getElementsByTagName("uses-feature")
            var featureFixed = 0
            for (i in 0 until features.length) {
                val el = features.item(i) as? Element ?: continue
                if (el.getAttribute("android:name") == "com.nothing.feature.ntwidget.V1_2") {
                    el.setAttribute("android:required", "false")
                    featureFixed++
                }
            }
            if (featureFixed == 0) throw Exception(
                "expected <uses-feature com.nothing.feature.ntwidget.V1_2> in manifest - " +
                    "anchor missing in this build"
            )

            // 2 - Drop the Nothing-launcher signature permission from providers.
            val providers = document.getElementsByTagName("provider")
            var unlocked = 0
            for (i in 0 until providers.length) {
                val el = providers.item(i) as? Element ?: continue
                if (el.getAttribute("android:permission") == "com.nothing.permission.BIND_CARD_SERVICE") {
                    el.removeAttribute("android:permission")
                    unlocked++
                }
            }
            if (unlocked == 0) throw Exception(
                "no BIND_CARD_SERVICE-gated providers found in manifest - " +
                    "anchor missing in this build"
            )

            // 3 - Give the app a regular launcher icon on any ROM.
            val activities = document.getElementsByTagName("activity")
            var iconAdded = false
            for (i in 0 until activities.length) {
                val el = activities.item(i) as? Element ?: continue
                if (el.getAttribute("android:name") != "com.nothing.hearthstone.quicklook.QuickLookSettingsActivity") continue
                val existing = el.getElementsByTagName("action")
                var hasMain = false
                for (j in 0 until existing.length) {
                    val a = existing.item(j) as? Element ?: continue
                    if (a.getAttribute("android:name") == "android.intent.action.MAIN") hasMain = true
                }
                if (hasMain) { iconAdded = true; break }
                val filter = document.createElement("intent-filter")
                val main = document.createElement("action")
                main.setAttribute("android:name", "android.intent.action.MAIN")
                val launcher = document.createElement("category")
                launcher.setAttribute("android:name", "android.intent.category.LAUNCHER")
                filter.appendChild(main)
                filter.appendChild(launcher)
                el.insertBefore(filter, el.firstChild)
                iconAdded = true
            }
            if (!iconAdded) throw Exception(
                "QuickLookSettingsActivity not found for launcher-icon injection - " +
                    "anchor missing in this build"
            )
        }
    }
}
