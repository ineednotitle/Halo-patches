package app.template.patches.firefox

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.template.patches.shared.Constants.FIREFOX_COMPATIBILITY

/**
 * Shrinks Firefox for Android (Fenix) to a strictly privacy-focused browser by
 * never letting the four data-collection subsystems initialize (all verified
 * against 158.0.2, where they are the only live telemetry pipes):
 *
 * - Glean / "Firefox Telemetry": initializeGlean() runs synchronously from
 *   FenixApplication.onCreate and wires the entire metrics pipeline. Never
 *   initializing means no metrics, no pings, no usage data, ever.
 * - Nimbus (FxNimbus.initialize): experiment enrollment and the experiments
 *   server sync. Skipped initialization means default feature states and no
 *   enrollment traffic.
 * - Sentry crash reporting (SentryService.initSentry): the crash-upload
 *   backend is never configured, so nothing can be reported.
 * - Adjust marketing attribution (AdjustMetricsService.start): install and
 *   activation attribution never start.
 *
 * Browsing, Sync, add-ons, and all browser features are untouched. All
 * fingerprints are Mozilla's public, non-obfuscated class names and matching
 * is fail-open: if Mozilla renames one of them, that call simply stays and
 * the rest of the app patches normally.
 */
@Suppress("unused")
val blockTelemetryPatch = bytecodePatch(
    name = "Block Firefox telemetry",
    description = "Never initializes Glean telemetry, Nimbus experiments, Sentry crash reporting, or Adjust " +
        "marketing attribution at startup. Browsing, Sync, add-ons and all features keep working.",
    default = true,
) {
    compatibleWith(FIREFOX_COMPATIBILITY)

    execute {
        // Glean: the whole metrics/telemetry pipeline inits exactly once, here.
        Fingerprint(
            definingClass = "Lorg/mozilla/fenix/components/GleanHelperKt;",
            name = "initializeGlean",
            returnType = "V",
            parameters = listOf(
                "Landroid/content/Context;",
                "Lmozilla/components/support/base/log/logger/Logger;",
                "Z",
                "Lmozilla/components/concept/fetch/Client;",
            ),
        ).method.addInstructions(0, "return-void")

        // Nimbus: experiment enrollment + experiments server sync.
        Fingerprint(
            definingClass = "Lorg/mozilla/fenix/nimbus/FxNimbus;",
            name = "initialize",
            returnType = "V",
            parameters = listOf("Lkotlin/jvm/functions/Function0;"),
        ).method.addInstructions(0, "return-void")

        // Sentry: crash-report backend init inside Mozilla's lib.crash wrapper.
        Fingerprint(
            definingClass = "Lmozilla/components/lib/crash/sentry/SentryService;",
            name = "initSentry\$lib_crash_sentry",
            returnType = "V",
            parameters = emptyList(),
        ).method.addInstructions(0, "return-void")

        // Adjust: marketing install/activation attribution service.
        Fingerprint(
            definingClass = "Lorg/mozilla/fenix/components/metrics/AdjustMetricsService;",
            name = "start",
            returnType = "V",
            parameters = emptyList(),
        ).method.addInstructions(0, "return-void")
    }
}
