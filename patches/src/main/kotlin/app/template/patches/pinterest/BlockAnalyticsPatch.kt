package app.template.patches.pinterest

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.template.patches.shared.Constants.PINTEREST_COMPATIBILITY

/**
 * Pinterest 14.41.0 bundles two live third-party data-collection stacks:
 *
 * - Firebase Analytics: event logging via FirebaseAnalytics.logEvent(...) and
 *   explicit collection toggling via setAnalyticsCollectionEnabled(...).
 * - AppsFlyer: install/activation attribution + deferred deep-link + in-app
 *   event logging (dev key hard-coded in the app, start() runs on launch).
 *
 * Rather than chasing Pinterest's obfuscated wrapper classes (renamed every
 * build), this patch neutralizes the public SDK entry points themselves,
 * inside the app's own dex: the SDK methods become no-ops, so wrapper calls
 * still run but nothing is recorded or sent. Returning from void methods can
 * never produce null surprises downstream — the classic, zero-risk tracker
 * kill. Push notifications (Firebase Messaging) and app integrity
 * (Installations) are untouched.
 */
@Suppress("unused")
val blockAnalyticsPatch = bytecodePatch(
    name = "Block analytics and data collection",
    description = "Turns Firebase Analytics and AppsFlyer calls into no-ops: no event logging, no " +
        "install/activation attribution, no collection toggling. Push notifications keep working; " +
        "Pinterest's own features are untouched.",
    default = true,
) {
    compatibleWith(PINTEREST_COMPATIBILITY)

    execute {
        // Firebase Analytics: event ingests and the collection toggle.
        Fingerprint(
            definingClass = "Lcom/google/firebase/analytics/FirebaseAnalytics;",
            name = "logEvent",
            returnType = "V",
            parameters = listOf("Ljava/lang/String;", "Landroid/os/Bundle;"),
        ).method.addInstructions(0, "return-void")

        Fingerprint(
            definingClass = "Lcom/google/firebase/analytics/FirebaseAnalytics;",
            name = "setAnalyticsCollectionEnabled",
            returnType = "V",
            parameters = listOf("Z"),
        ).method.addInstructions(0, "return-void")

        // AppsFlyer: attribution start and in-app event logging.
        Fingerprint(
            definingClass = "Lcom/appsflyer/AppsFlyerLib;",
            name = "start",
            returnType = "V",
            parameters = listOf("Landroid/content/Context;"),
        ).method.addInstructions(0, "return-void")

        Fingerprint(
            definingClass = "Lcom/appsflyer/AppsFlyerLib;",
            name = "logEvent",
            returnType = "V",
            parameters = listOf("Landroid/content/Context;", "Ljava/lang/String;", "Ljava/util/Map;"),
        ).method.addInstructions(0, "return-void")
    }
}
