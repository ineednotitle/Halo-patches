package app.template.patches.nothinglauncher.universal

import app.morphe.patcher.patch.resourcePatch
import app.template.patches.shared.Constants.NOTHING_LAUNCHER_COMPATIBILITY
import org.w3c.dom.Element

/**
 * Lets Nothing Launcher install on non-Nothing devices (ColorOS, realme UI, One UI, ...).
 *
 * Ground truth from the decoded official 3.3.10 (vc 3031001) build:
 * the ONLY device gate anywhere in the app is the manifest entry
 *     <uses-feature android:name="com.nothing.feature.OS.V2_5_Beta2" android:required="true"/>
 * which makes Google Play / bundle installers hide the app from non-Nothing-OS
 * devices. The launcher contains no runtime brand/model/feature check that
 * exits or degrades it when sideloaded elsewhere (verified: zero
 * hasSystemFeature / Build.BRAND / Build.MANUFACTURER gates under
 * com.nothing.launcher), so making the feature non-required is the whole fix.
 * A launcher is a normal home-replacement app on any ROM; users then pick it
 * in system Home settings. Nothing-only card data (hearthstone ContentProviders)
 * flows in only when the (also patched) Nothing Widgets app is installed.
 *
 * Second move (added in 1.6.1 after on-device report): like AOSP Launcher3,
 * Nothing Launcher's home activity declares categories HOME + DEFAULT +
 * LAUNCHER_APP but NEVER LAUNCHER - so the app has no drawer icon on any
 * launcher, and "open" taps from app lists/Settings run no intent (dead
 * click). We append android.intent.category.LAUNCHER to the home activity's
 * intent-filter, producing a normal drawer icon whose tap lands on the home
 * surface (and prompts the default-homepicker on first use).
 */
@Suppress("unused")
val nothingLauncherUniversalPatch = resourcePatch(
    name = "Universal Android compatibility",
    description = "Lets Nothing Launcher install & run on non-Nothing ROMs (ColorOS, realme UI, ...) " +
        "by lifting the Nothing-OS feature filter. Then set it as your Home app in system settings.",
    default = true,
) {
    compatibleWith(NOTHING_LAUNCHER_COMPATIBILITY)

    execute {
        document("AndroidManifest.xml").use { document ->
            val features = document.getElementsByTagName("uses-feature")
            var fixed = 0
            for (i in 0 until features.length) {
                val el = features.item(i) as? Element ?: continue
                if (el.getAttribute("android:name") == "com.nothing.feature.OS.V2_5_Beta2") {
                    el.setAttribute("android:required", "false")
                    fixed++
                }
            }
            if (fixed == 0) throw Exception(
                "expected <uses-feature com.nothing.feature.OS.V2_5_Beta2> in manifest - " +
                    "anchor missing in this build"
            )

            // Drawer icon: add LAUNCHER category next to the HOME category in the
            // launcher's home activity (com.android.searchlauncher.SearchLauncher).
            val activities = document.getElementsByTagName("activity")
            var iconAdded = false
            for (i in 0 until activities.length) {
                val el = activities.item(i) as? Element ?: continue
                if (el.getAttribute("android:name") != "com.android.searchlauncher.SearchLauncher") continue
                val filters = el.getElementsByTagName("intent-filter")
                for (j in 0 until filters.length) {
                    val f = filters.item(j) as? Element ?: continue
                    val cats = f.getElementsByTagName("category")
                    var hasHome = false
                    var hasLauncher = false
                    for (k in 0 until cats.length) {
                        val c = cats.item(k) as? Element ?: continue
                        when (c.getAttribute("android:name")) {
                            "android.intent.category.HOME" -> hasHome = true
                            "android.intent.category.LAUNCHER" -> hasLauncher = true
                        }
                    }
                    if (hasHome && !hasLauncher) {
                        val launcher = document.createElement("category")
                        launcher.setAttribute("android:name", "android.intent.category.LAUNCHER")
                        f.appendChild(launcher)
                        iconAdded = true
                        break
                    }
                }
                if (iconAdded) break
            }
            if (!iconAdded) throw Exception(
                "SearchLauncher activity with HOME category not found for LAUNCHER-category " +
                    "injection - anchor missing in this build"
            )
        }
    }
}
