package app.template.patches.mereframe

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.extensions.InstructionExtensions.replaceInstruction
import app.morphe.patcher.patch.bytecodePatch
import app.template.patches.shared.Constants.MEREFRAME_COMPATIBILITY

/**
 * Mereframe 0.8.4 introduced a Pro tier; entitlement resolution happens in
 * exactly one function of the vendored licensing SDK:
 *
 *   Lnv;->e(Landroid/content/Context;LSv;Ljava/util/List;)Ljava/util/Set;
 *
 * It iterates the feature registry (the p2 List, all pluggable features with
 * a feature key Ru.a and a default-availability flag Ru.a()Z) and only adds a
 * feature to the enabled set when the *owned-id list* (Sv.a()) CONTAINS the
 * key. All feature consumers (Il, ns) read the set produced here; kill the
 * contains-guard and every registered feature resolves enabled - no web call,
 * no account, no Play Billing interaction needed.
 *
 * The edit is surgical: the single `if-eqz v6, :cond_0` right after
 * ArrayList.contains() is replaced by `nop`, so the skip path for "not owned"
 * disappears while Ru.a()Z (the vendor's own per-feature availability flag)
 * stays respected. No new instructions, no labels introduced; the register
 * v6/isolation pattern is verified against 0.8.4 (vc 118).
 *
 * Pair with "Allow re-signed/sideloaded installs": the stock APK checks the
 * installer signature, without that patch the app refuses to start at all.
 * Fail-open: any structural drift makes the fingerprints throw instead of
 * silently half-patching.
 */
@Suppress("unused")
val unlockProPatch = bytecodePatch(
    name = "Unlock Pro features",
    description = "Includes every registered feature in the resolved feature set by dropping the " +
        "ownership check at the entitlement resolver (nv.e). UI surfaces reading it show Pro " +
        "functionality unlocked. Local client-side effect only.",
    default = true,
) {
    compatibleWith(MEREFRAME_COMPATIBILITY)

    execute {
        val method = Fingerprint(
            definingClass = "Lnv;",
            name = "e",
            returnType = "Ljava/util/Set;",
            parameters = listOf("Landroid/content/Context;", "LSv;", "Ljava/util/List;"),
        ).method

        method.apply {
            val containsIdx = implementation!!.instructions.indexOfFirst {
                it.toString().contains("->contains(Ljava/lang/Object;)Z")
            }
            require(containsIdx >= 0) { "nv.e: contains() not found" }
            val ifIdx = containsIdx + 2 // invoke-virtual -> move-result -> if-eqz
            val ifText = implementation!!.instructions.elementAt(ifIdx).toString()
            require(ifText.startsWith("if-eqz")) { "nv.e: unexpected layout after contains(): $ifText" }
            replaceInstruction(ifIdx, "nop")
        }
    }
}
