package app.template.patches.reddit.premium

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.PatchException
import app.morphe.patcher.patch.bytecodePatch
import app.morphe.patcher.util.proxy.mutableTypes.MutableMethod
import app.template.patches.shared.Constants.REDDIT_COMPATIBILITY
import com.android.tools.smali.dexlib2.Opcode
import com.android.tools.smali.dexlib2.iface.instruction.OneRegisterInstruction
import com.android.tools.smali.dexlib2.iface.instruction.ReferenceInstruction
import com.android.tools.smali.dexlib2.iface.instruction.WideRangeInstruction
import com.android.tools.smali.dexlib2.iface.instruction.formats.Instruction35c
import com.android.tools.smali.dexlib2.iface.reference.MethodReference
import com.android.tools.smali.dexlib2.iface.reference.StringReference

/**
 * Unlock Premium (local) — Reddit
 *
 * Verified against Reddit 2026.42.0 (versionCode 2642021, 16 Oct 2026).
 *
 * WHAT THIS DOES (data-source surgery):
 *   AccountJsonAdapter.fromJson() converts the /api/v1/me JSON into every
 *   Account object the app ever uses. The patch forces three JSON booleans to
 *   true at the exact Account construction sites:
 *     is_gold                      → Account.hasPremium
 *     has_gold_subscription        → Account.isPremiumSubscriber
 *     has_premium_avatar_treatment → Account.hasPremiumAvatarTreatment
 *   Result: the app behaves as Reddit Premium — custom app icons, premium
 *   avatar treatment, premium-marketing surfaces lose their paywall.
 *
 * WHAT THIS CANNOT DO (server-validated, unpatchable):
 *   r/lounge, monthly coins, synced ad-free preference. Use "Remove ads" for
 *   the ad-free experience.
 *
 * HOW THE SURGERY WORKS (no hardcoded registers):
 *   1. Read the Moshi JsonReader.Options table from the adapter <init>:
 *      const-string entries are filled-new-array'ed in declaration order —
 *      the array index of each JSON key equals the Account primary-constructor
 *      parameter index for that property.
 *   2. Find every `invoke-direct … Account.<init>(…)` in fromJson. There are
 *      two construction paths (full ctor at :goto_551 and the
 *      DefaultConstructorMarker fallback at :cond_58f); both are patched.
 *   3. For each invoke, compute the register holding each premium param:
 *      reg = rangeStart + 1 (this) + Σ param widths (J/D count as two).
 *   4. Inject `const/4 vR, 0x1` immediately before each invoke.
 *
 *   Verified on 2026.42.0 smali: computes v21/v22/v24 (full-ctor path) and
 *   v18/v19/v21 (marker path), matching the hand-verified registers in the dump.
 *
 *   Injections are applied in REVERSE instruction order so earlier indices
 *   stay valid while the method grows.
 */
private const val ACCOUNT_CLASS = "Lcom/reddit/domain/model/Account;"

@Suppress("unused")
val redditUnlockPremiumPatch = bytecodePatch(
    name = "Unlock Premium",
    description = "Flips the local isGold/has_gold_subscription account flags at the JSON " +
        "adapter to enable Reddit Premium UI (custom icons, premium screens). " +
        "Server-side perks cannot be unlocked.",
    default = true,
) {
    compatibleWith(REDDIT_COMPATIBILITY)

    execute {
        val fromJsonMethod = AccountFromJsonFingerprint.method
        val optionsConstructor = AccountJsonAdapterConstructorFingerprint.method

        // ── Step 1: JSON key → parameter index (Moshi options table order) ───
        val jsonKeyOrder = optionsConstructor.parseJsonKeyOrder()
        val premiumParams = listOf(
            "is_gold",
            "has_gold_subscription",
            "has_premium_avatar_treatment",
        ).map { jsonKeyOrder.indexOf(it) }.filter { it >= 0 }

        if (!jsonKeyOrder.contains("is_gold")) {
            throw PatchException(
                "Unlock Premium: 'is_gold' missing from Moshi options table " +
                    "(parsed order=$jsonKeyOrder). Re-verify: " +
                    "grep -rln '\"is_gold\"' smali*/ | grep -i adapter"
            )
        }
        println("Unlock Premium: options-order premium param indices → $premiumParams")

        // ── Step 2: locate Account construction sites + plan injections ──────
        val instructions = fromJsonMethod.implementation?.instructions?.toList()
            ?: throw PatchException("Unlock Premium: fromJson has no body")

        val plannedInjections = mutableListOf<Pair<Int, String>>() // index → smali

        instructions.forEachIndexed { index, instruction ->
            if (instruction.opcode != Opcode.INVOKE_DIRECT_RANGE) {
                return@forEachIndexed
            }
            val reference = (instruction as? ReferenceInstruction)?.reference
                as? MethodReference ?: return@forEachIndexed
            if (reference.definingClass != ACCOUNT_CLASS || reference.name != "<init>") {
                return@forEachIndexed
            }

            val range = instruction as? WideRangeInstruction
                ?: throw PatchException("Unlock Premium: Account <init> invoke is not /range form")

            val parameterTypes = reference.parameterTypes.map { it.toString() }
            val injection = buildString {
                premiumParams.forEach { paramIndex ->
                    if (paramIndex >= parameterTypes.size) return@forEach
                    var reg = range.startRegister + 1 // +1 = 'this'
                    for (i in 0 until paramIndex) {
                        reg += if (parameterTypes[i] == "J" || parameterTypes[i] == "D") 2 else 1
                    }
                    append("const/4 v$reg, 0x1\n")
                }
            }.trim()

            if (injection.isNotEmpty()) {
                plannedInjections.add(index to injection)
                println("Unlock Premium: planned invoke @#$index:\n$injection")
            }
        }

        if (plannedInjections.isEmpty()) {
            throw PatchException(
                "Unlock Premium: no Account <init> call site found inside fromJson. " +
                    "Re-verify the adapter class in a fresh apktool dump."
            )
        }

        // ── Step 3: apply from the END so earlier indices stay valid ─────────
        plannedInjections
            .sortedByDescending { it.first }
            .forEach { (index, smali) -> addInstructions(index, smali) }

        println("Unlock Premium: patched ${plannedInjections.size} Account construction site(s).")
    }
}

/**
 * Parse the ordered JSON key names from a Moshi adapter constructor.
 *
 * The ctor assigns `const-string vN, "<key>"` per property and fills the
 * JsonReader.Options array (filled-new-array, or filled-new-array/range for
 * the 54-key Reddit Account table). Array index == constructor param index.
 * If the fill can't be located, fall back to ascending register order —
 * R8/Moshi codegen assigns the option strings to sequential registers.
 */
private fun MutableMethod.parseJsonKeyOrder(): List<String> {
    val instructions = implementation?.instructions?.toList()
        ?: throw PatchException("Unlock Premium: adapter <init> has no body")

    val registerStrings = HashMap<Int, String>()
    var filledArrayRegisters = listOf<Int>()

    for (instruction in instructions) {
        when {
            instruction.opcode == Opcode.CONST_STRING -> {
                val ref = (instruction as? ReferenceInstruction)?.reference as? StringReference
                val dest = (instruction as? OneRegisterInstruction)?.registerA
                if (ref != null && dest != null) registerStrings[dest] = ref.string
            }

            instruction.opcode == Opcode.FILLED_NEW_ARRAY -> {
                val regs = (instruction as? Instruction35c)?.registers?.toList().orEmpty()
                if (regs.size > 3) filledArrayRegisters = regs
            }

            instruction.opcode == Opcode.FILLED_NEW_ARRAY_RANGE -> {
                val range = instruction as? WideRangeInstruction
                if (range != null && range.registerCount > 3) {
                    filledArrayRegisters =
                        (range.startRegister until range.startRegister + range.registerCount).toList()
                }
            }
        }
    }

    val order = filledArrayRegisters.ifEmpty { registerStrings.keys.sorted() }
    return order.mapNotNull { registerStrings[it] }
}
