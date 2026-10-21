package app.template.patches.shared

import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.patch.PatchException
import app.morphe.patcher.util.proxy.mutableTypes.MutableMethod
import com.android.tools.smali.dexlib2.builder.BuilderTryBlock
import com.android.tools.smali.dexlib2.builder.MutableMethodImplementation

/**
 * Doom's smali-surgery toolbox (trimmed to what the Reddit patches need).
 *
 * ─────────────────────────────────────────────────────────────────────────────
 * WARNING (learned the hard way by Doom, kept here verbatim in spirit):
 *
 * NEVER clearBody() a coroutine state machine or any method containing a
 * packed-switch — the switch payload table is stored between instructions and
 * dies with the body, producing ART VerifyError ("check-cast on non-reference")
 * at runtime. For those methods, use addInstructions(0, ...) to short-circuit
 * BEFORE the switch is ever reached, leaving the original body intact.
 * ─────────────────────────────────────────────────────────────────────────────
 */

/**
 * Wipe the method body in place: drops every instruction AND every try/catch
 * range. Required before replacing a method body via addInstructions() when the
 * original method has try-blocks — leaving the try table pointing at removed
 * offsets causes ART VerifyError ("bad exception entry").
 */
fun MutableMethod.clearBody() {
    val impl = implementation ?: return
    val field = tryBlocksField
        ?: throw PatchException(
            "MutableMethodImplementation has no List<BuilderTryBlock> field. dexlib2 layout changed?",
        )
    @Suppress("UNCHECKED_CAST")
    (field.get(impl) as MutableList<BuilderTryBlock>).clear()
    val n = impl.instructions.toList().size
    repeat(n) { impl.removeInstruction(0) }
}

private val tryBlocksField: java.lang.reflect.Field? = run {
    MutableMethodImplementation::class.java.declaredFields
        .firstOrNull { f ->
            if (!MutableList::class.java.isAssignableFrom(f.type) &&
                !List::class.java.isAssignableFrom(f.type)
            ) return@firstOrNull false
            val generic = f.genericType as? java.lang.reflect.ParameterizedType ?: return@firstOrNull false
            val arg = generic.actualTypeArguments.firstOrNull() ?: return@firstOrNull false
            arg.typeName == BuilderTryBlock::class.java.name ||
                arg.typeName.startsWith("${BuilderTryBlock::class.java.name}<")
        }
        ?.apply { isAccessible = true }
}

/**
 * Grow the method's register count to [needed] if currently smaller.
 *
 * `registerCount` is `private final int` on the dexlib2 builder implementation,
 * so this goes through reflection (same approach as Doom). Bump BEFORE
 * clearBody()/addInstructions(); bumping after assembly has no effect. Smali
 * register math for non-static methods with P parameters:
 *   total = locals + (1 + P), so p0 = v[total - 1 - P]
 * Adding a register pushes parameter slots up, keeping p0/p1 references valid.
 */
fun MutableMethod.ensureRegisters(needed: Int) {
    val impl = implementation ?: return
    if (impl.registerCount >= needed) return
    val field = MutableMethodImplementation::class.java.declaredFields
        .firstOrNull { it.type == Int::class.javaPrimitiveType }
        ?.apply { isAccessible = true }
        ?: throw PatchException(
            "MutableMethodImplementation has no int field (registerCount). dexlib2 layout changed?",
        )
    field.setInt(impl, needed)
}

/**
 * Replace the whole method with an immediate constant return.
 * This mirrors what Doom inlines by hand in most of his premium patches:
 *   clearBody() + inject "const/4 v0, 0x1; return v0".
 *
 * Safe ONLY for non-coroutine methods (see file header).
 */
fun MutableMethod.returnTrue() {
    check(returnType == "Z") { "returnTrue() only valid on Z-returning methods, found $returnType" }
    clearBody()
    addInstructions(0, "const/4 v0, 0x1\nreturn v0")
}

fun MutableMethod.returnFalse() {
    check(returnType == "Z") { "returnFalse() only valid on Z-returning methods, found $returnType" }
    clearBody()
    addInstructions(0, "const/4 v0, 0x0\nreturn v0")
}

fun MutableMethod.returnVoid() {
    check(returnType == "V") { "returnVoid() only valid on V-returning methods, found $returnType" }
    clearBody()
    addInstructions(0, "return-void")
}
