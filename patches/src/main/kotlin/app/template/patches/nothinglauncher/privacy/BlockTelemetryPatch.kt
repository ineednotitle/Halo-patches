package app.template.patches.nothinglauncher.privacy

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patcher.patch.resourcePatch
import app.template.patches.shared.Constants.NOTHING_LAUNCHER_COMPATIBILITY
import org.w3c.dom.Element

/**
 * Blocks Nothing Launcher's telemetry at both layers it exists on
 * (verified against the official 3.3.10 / vc 3031001 build):
 *
 *  1. App layer — FcmSdkHelper.b() uploads two Firebase Analytics custom
 *     properties ("nothing_os_version", "nothing_os_build_number") from
 *     NTLauncherApplication.onCreate. It is the ONLY app-level analytics
 *     call site in the package (L1/a accessor has no other callers; the FCM
 *     token fetch in c() is debug-log gated and goes nowhere). Head-kill.
 *
 *  2. Google layer (auto-collection) — firebase-analytics contains no
 *     setAnalyticsCollectionEnabled in this build (R8 stripped every unused
 *     SDK method), so the kill happens one level higher: the two analytics
 *     component registrars are removed from ComponentDiscoveryService, so
 *     Firebase's auto event collection (first_open, session_start, ...) is
 *     never materialized. Firebase Messaging, Installations and
 *     Datatransport registrars are deliberately kept, so Nothing push
 *     notifications keep working.
 *
 * Verified: this build carries no Crashlytics/Perf/perf-monitoring, no
 * third-party tracker SDKs, and no AppMeasurement receivers in the manifest.
 */
private val nothingLauncherTelemetryResourcePatch = resourcePatch {
    execute {
        document("AndroidManifest.xml").use { document ->
            val analyticsRegistrars = setOf(
                "com.google.firebase.components:com.google.firebase.analytics.ktx.FirebaseAnalyticsLegacyRegistrar",
                "com.google.firebase.components:com.google.firebase.analytics.connector.internal.AnalyticsConnectorRegistrar",
            )
            val meta = document.getElementsByTagName("meta-data")
            var removed = 0
            // walk backwards: removing nodes while iterating a live NodeList
            var i = meta.length - 1
            while (i >= 0) {
                val el = meta.item(i) as? Element
                if (el != null && el.getAttribute("android:name") in analyticsRegistrars) {
                    el.parentNode.removeChild(el)
                    removed++
                }
                i--
            }
            if (removed != analyticsRegistrars.size) throw Exception(
                "expected ${analyticsRegistrars.size} analytics registrar meta-data entries, " +
                    "removed $removed - anchor drift in this build"
            )
        }
    }
}

@Suppress("unused")
val nothingLauncherBlockTelemetryPatch = bytecodePatch(
    name = "Block analytics & data collection",
    description = "Stops Nothing Launcher from reporting device/ROM identifiers via Firebase Analytics: " +
        "kills the ROM-version user-property upload and disables Google's automatic analytics " +
        "collection (registrar removal). Push notifications keep working.",
    default = true,
) {
    compatibleWith(NOTHING_LAUNCHER_COMPATIBILITY)
    dependsOn(nothingLauncherTelemetryResourcePatch)

    execute {
        // FcmSdkHelper.b(): .locals 5 void method - head-kill with a bare return.
        FcmSdkHelperUploadUserPropertiesFingerprint.method.addInstructions(
            0,
            "return-void",
        )
    }
}
