package app.template.patches.pinterest

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.bytecodePatch
import app.template.patches.shared.Constants.PINTEREST_COMPATIBILITY

/**
 * Pinterest blends promoted (sponsored) Pins into the home feed, search
 * results, related pins and boards, tagged with the server flag
 * "is_promoted". Every pin list Pinterest shows is assembled in exactly one
 * place: PinDeserializer.a(...) iterates the response array, keeps items of
 * type "pin", parses each into a pin model and List.add()s it.
 *
 * This patch inserts a guard right before that List.add: if the pin's
 * is_promoted flag resolves to Boolean.TRUE, the pin is skipped and never
 * enters any list — so no promoted pin is ever laid out, rendered or clicked.
 * Pins whose flag is absent (organic content, the common case) pass through.
 * The single-pin closeup path (method f) is deliberately not touched, so
 * opening a Pin link directly still works.
 *
 * Verified against 14.41.0 (apkmirror universal APK, vc 14418020); the
 * deserializer package/class names are Pinterest-public and stable.
 */
@Suppress("unused")
val removePromotedPinsPatch = bytecodePatch(
    name = "Ad-free feed (remove promoted Pins)",
    description = "Filters promoted/sponsored Pins out of every feed, search result, and board " +
        "list at the deserialization choke point, before they ever render. Organic pinning, " +
        "boards and saving are unaffected.",
    default = true,
) {
    compatibleWith(PINTEREST_COMPATIBILITY)

    execute {
        val method = Fingerprint(
            definingClass = "Lcom/pinterest/api/model/deserializer/PinDeserializer;",
            name = "a",
            returnType = "Ljava/util/List;",
            parameters = listOf("Ltm0/a;"),
        ).method

        method.apply {
            // Locate the List.add(v0, v4) that appends each parsed pin.
            // NOTE: dexlib2 toString() renders registers without apktook spacing,
            // so match on the method signature fragment only (unique here).
            val addIndex = implementation!!.instructions.indexOfFirst {
                it.toString().contains("Ljava/util/List;->add(Ljava/lang/Object;)Z")
            }
            require(addIndex >= 0) { "PinDeserializer.a(): List.add not found" }

            // Insert the promoted guard immediately before the add.
            // v4 = pin model, v5 = scratch (only used as a temp in this loop).
            addInstructions(
                addIndex,
                """
                    invoke-virtual { v4 }, Lcom/pinterest/api/model/pe;->Z5()Ljava/lang/Boolean;
                    move-result-object v5
                    if-eqz v5, :halo_add_pin
                    invoke-virtual { v5 }, Ljava/lang/Boolean;->booleanValue()Z
                    move-result v5
                    if-eqz v5, :halo_skip_pin
                    :halo_add_pin
                """.trimIndent(),
            )

            // The original List.add shifted right; land the skip label after it.
            val addIndexNow = implementation!!.instructions.indexOfFirst {
                it.toString().contains("Ljava/util/List;->add(Ljava/lang/Object;)Z")
            }
            addInstructions(addIndexNow + 1, ":halo_skip_pin")
        }
    }
}
