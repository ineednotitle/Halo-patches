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
 * type "pin", parses each into a pin model and returns the list.
 *
 * This patch appends a self-contained filter loop right before the method's
 * single return: any entry whose is_promoted flag resolves to Boolean.TRUE
 * is removed from the returned list, so promoted pins are never laid out,
 * rendered or clicked anywhere. Pins whose flag is absent (organic content,
 * the common case) pass through. The single-pin closeup path (method f is
 * deliberately not touched, so opening a Pin link directly still works.
 *
 * The insertion anchors ONLY on "the instruction before return" (a fixed
 * position), never on formatting of existing instruction text - register
 * rendering differs between apktool smali dumps and dexlib2 dumping, which
 * is what burned v1.10.0/v1.10.1's middle-of-method locator. Verified pins:
 * registers v1/v2/v3/v5 are dead at method end, the whole block fits locals.
 * Verified against 14.41.0 (vc 14418020).
 */
@Suppress("unused")
val removePromotedPinsPatch = bytecodePatch(
    name = "Ad-free feed (remove promoted Pins)",
    description = "Filters promoted/sponsored Pins out of every feed, search result, and board " +
        "list at the deserialization choke point, so they never render. Organic pinning, boards " +
        "and saving are unaffected.",
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
            val instructionCount = implementation!!.instructions.size
            addInstructions(
                instructionCount - 1, // before return-object v0 (v0 = the pin list)
                """
                    const/4 v3, 0x0
                    :halo_filter_loop
                    invoke-interface { v0 }, Ljava/util/List;->size()I
                    move-result v2
                    if-ge v3, v2, :halo_filter_done
                    invoke-interface { v0, v3 }, Ljava/util/List;->get(I)Ljava/lang/Object;
                    move-result-object v1
                    check-cast v1, Lcom/pinterest/api/model/pe;
                    invoke-virtual { v1 }, Lcom/pinterest/api/model/pe;->Z5()Ljava/lang/Boolean;
                    move-result-object v5
                    if-eqz v5, :halo_filter_next
                    invoke-virtual { v5 }, Ljava/lang/Boolean;->booleanValue()Z
                    move-result v5
                    if-nez v5, :halo_filter_next
                    invoke-interface { v0, v3 }, Ljava/util/List;->remove(I)Ljava/lang/Object;
                    goto :halo_filter_loop
                    :halo_filter_next
                    add-int/lit8 v3, v3, 0x1
                    goto :halo_filter_loop
                    :halo_filter_done
                """.trimIndent(),
            )
        }
    }
}
