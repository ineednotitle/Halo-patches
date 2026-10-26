package app.template.patches.mereframe

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.extensions.InstructionExtensions.replaceInstruction
import app.morphe.patcher.patch.bytecodePatch
import app.template.patches.shared.Constants.MEREFRAME_COMPATIBILITY
import app.template.patches.shared.clearBody

/**
 * Mereframe 0.8.4 (vc 118) contains a self-defense layer: on launch it decides
 * whether the installation is "legitimate" (Play-signed, expected installer)
 * and, on refusal, substitutes the real entry points with
 * InstallationProblemActivity / RejectedInstallationService. ANY re-signed
 * patched APK (e.g. after Morphe patching) trips this gate and the app never
 * starts. This patch is therefore the REQUIRED companion for anything else in
 * our bundle - it neutralizes the three enforcement points:
 *
 * 1. UnnamedApp.a()Z  -> always true (the startup verdict shared by three
 *    gate call sites).
 * 2. InstallationComponentFactory.instantiateActivity: the single
 *    `if-eqz p0, :cond_0` that routes to InstallationProblemActivity is
 *    NOP'd, always falling through into the real reflective instantiation.
 *    (The :cond_0 and catch blocks stay - never reached, never referenced.)
 * 3. InstallationComponentFactory.instantiateService: `if-nez p0, :cond_1`
 *    becomes `goto :cond_1` - always the normal instantiation path; the
 *    RejectedInstallationService dead-branch stays unreferenced.
 *
 * No new labels are introduced; both edits are single-instruction rewrites on
 * a build-pinned layout, fail-open via fingerprints. Only the self-protection
 * verdict changes - all the app's normal behaviors and UI stay untouched.
 */
@Suppress("unused")
val allowReSignedInstallPatch = bytecodePatch(
    name = "Allow re-signed/sideloaded installs",
    description = "Neutralizes Mereframe's install-integrity checks so patched (re-signed) builds " +
        "start normally instead of showing the installation-refused screen. Required for any other " +
        "patch here to be usable.",
    default = true,
) {
    compatibleWith(MEREFRAME_COMPATIBILITY)

    execute {
        // 1) Startup verdict -> always accepted.
        Fingerprint(
            definingClass = "Lapp/unnamed/rawrecording/UnnamedApp;",
            name = "a",
            returnType = "Z",
            parameters = emptyList(),
        ).method.apply {
            clearBody()
            addInstructions(0, "const/4 v0, 0x1\nreturn v0")
        }

        // 2) Activity instantiation: NOP the route-to-InstallationProblem branch.
        Fingerprint(
            definingClass = "Lapp/unnamed/rawrecording/InstallationComponentFactory;",
            name = "instantiateActivity",
            returnType = "Landroid/app/Activity;",
            parameters = listOf("Ljava/lang/ClassLoader;", "Ljava/lang/String;", "Landroid/content/Intent;"),
        ).method.apply {
            val idx = implementation!!.instructions.indexOfFirst {
                it.toString().startsWith("if-eqz p0, :cond_0")
            }
            require(idx >= 0) { "instantiateActivity: rejection branch not found" }
            replaceInstruction(idx, "nop")
        }

        // 3) Service instantiation: always take the normal path.
        Fingerprint(
            definingClass = "Lapp/unnamed/rawrecording/InstallationComponentFactory;",
            name = "instantiateService",
            returnType = "Landroid/app/Service;",
            parameters = listOf("Ljava/lang/ClassLoader;", "Ljava/lang/String;", "Landroid/content/Intent;"),
        ).method.apply {
            val idx = implementation!!.instructions.indexOfFirst {
                it.toString().startsWith("if-nez p0, :cond_1")
            }
            require(idx >= 0) { "instantiateService: rejection branch not found" }
            replaceInstruction(idx, "goto :cond_1")
        }
    }
}
