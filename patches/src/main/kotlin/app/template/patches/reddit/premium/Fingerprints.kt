package app.template.patches.reddit.premium

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.string
import com.android.tools.smali.dexlib2.AccessFlags

/**
 * Targets AccountJsonAdapter.fromJson(JsonReader) — the Moshi deserialization
 * entry point that converts Reddit's /api/v1/me JSON into the in-memory
 * Lcom/reddit/domain/model/Account; object.
 *
 * WHY THIS ANCHOR (data-source surgery > leaf-patch surgery):
 *   The app consults Account.hasPremium / isPremiumSubscriber in only a
 *   handful of places, but those places are version-dependent UI code.
 *   The Moshi adapter is THE stable choke point: every Account object the app
 *   ever sees is born here, and JSON key names ("is_gold",
 *   "has_gold_subscription", "has_premium_avatar_treatment") are a public API
 *   contract — R8 cannot rename payload strings.
 *
 * Verified on Reddit 2026.42.0 (APK 2642021, Oct 2026):
 *   class  : smali_classes4/com/reddit/domain/model/AccountJsonAdapter.smali
 *   method : fromJson(Lcom/squareup/moshi/e;)Ljava/lang/Object;   (line 1389)
 *   strings: const-string v13, "is_gold"  (options table, line 244)
 *   ctor   : Account.<init> has 54 params; param #11 = hasPremium,
 *            #12 = isPremiumSubscriber, #14 = hasPremiumAvatarTreatment
 *            (with the J param #3 consuming two registers: 11→v21, 12→v22,
 *            14→v24 at the {v8..v63} construction site, and →v18,v19,v21 at
 *            the DefaultConstructorMarker fallback site)
 *
 * ── How to re-verify after a Reddit update ─────────────────────────────────
 *   apktool d reddit.apkm
 *   grep -rln '"is_gold"' smali* / | grep -i adapter
 *   → find the AccountJsonAdapter class, confirm fromJson still builds
 *     Lcom/reddit/domain/model/Account; via invoke-direct …<init>(…).
 *   The patch re-derives param positions from the JSON options table at patch
 *   time, so reshuffled property order is handled automatically; only the
 *   disappearance of the adapter or the JSON keys themselves breaks it.
 * ──────────────────────────────────────────────────────────────────────────
 */
object AccountFromJsonFingerprint : Fingerprint(
    name = "fromJson",
    returnType = "Ljava/lang/Object;",
    parameters = listOf("L"),
    filters = listOf(
        string("is_gold"),
        string("has_gold_subscription"),
        string("has_premium_avatar_treatment")
    )
)

/**
 * AccountJsonAdapter constructor — builds the Moshi JsonReader.Options table
 * (the ordered JSON key names). The patch reads this table to compute which
 * constructor parameter (and therefore which register) carries each premium
 * boolean at the Account construction sites inside fromJson.
 */
object AccountJsonAdapterConstructorFingerprint : Fingerprint(
    name = "<init>",
    returnType = "V",
    parameters = listOf("L"),
    filters = listOf(
        string("is_gold"),
        string("has_gold_subscription")
    )
)
