package app.template.patches.reddit.removeads

import app.morphe.patcher.Fingerprint
import app.morphe.patcher.fieldAccess
import app.morphe.patcher.methodCall
import app.morphe.patcher.string
import com.android.tools.smali.dexlib2.AccessFlags
import com.android.tools.smali.dexlib2.Opcode

/**
 * Reddit feed/comment ad anchors — verified against Reddit 2026.42.0
 * (versionCode 2642021, 16 Oct 2026 APK) with apktool/baksmali:
 *
 *   Listing            : smali_classes6/com/reddit/domain/model/listing/Listing.smali
 *                        <init> writes ->children / ->after / ->before (UNCHANGED)
 *   SubmittedListing   : ABSENT (removed in 2026.16.0+, layer auto-skips)
 *   CommentsViewModel  : smali_classes8/.../CommentsViewModel.smali
 *                        one PUBLIC FINAL (Z,L,I)V: P(ZLcbc;I)V @#7346 containing
 *                        invoke-direct {v4,p1,v5}, La0a;-><init>(ZI)V  ✔
 *   CommentsAdState    : smali_classes8/ria.smali — toString renders
 *                        "CommentsAdState(conversationAdViewState=" and
 *                        ", adsLoadCompleted=" followed by iget-boolean ->h:Z,
 *                        whose <init> writes it via `iput-boolean p8, p0, ->h:Z`  ✔
 *
 * REMOVED 2026.42.0 (formerly "new-feed AdPostSection sections" layer):
 *   The upstream p5-sections injection was STALE here — in this build the class
 *   with toString "AdPostSection(linkId=" (com/reddit/ads/impl/feeds/composables/c.smali)
 *   has <init>(String,String,Ljs0;,AdAnalyticsInfo,Lvwp;,Z,ClickVisibilityDurationVariant,
 *   Lty8;,Lal80;,Lnl0;,Z,Luu40;,Z)V — p5 is an Lvwp; model, NOT a sections List.
 *   Injecting there would VerifyError. Promoted ITEMS are still caught at the
 *   Listing layer. If Reddit reintroduces a sections-list constructor, re-add
 *   after a fresh dump review.
 *
 * ── How to re-verify after a Reddit update (apktool d reddit.apkm) ──────────
 *  1. smali* /com/reddit/domain/model/listing/Listing.smali → same 3 field writes
 *  2. grep -rl '"CommentsAdState(conversationAdViewState="' smali* /
 *  3. smali* /com/reddit/comments/presentation/CommentsViewModel.smali
 *     → public final V-method (Z, L..., I) new'ing an ad loader via <init>(ZI)V
 * ──────────────────────────────────────────────────────────────────────────
 */

/**
 * Lcom/reddit/domain/model/listing/Listing;-><init> — old-style feed model
 * (home/popular/subreddit/search/custom-feed list surfaces all construct it;
 * verified 8 new-instance sites incl. com/reddit/data/remote/{g,e,h}).
 * `children` carries feed rows incl. promoted ILink items.
 */
object ListingFingerprint : Fingerprint(
    definingClass = "Lcom/reddit/domain/model/listing/Listing;",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.CONSTRUCTOR),
    filters = listOf(
        fieldAccess(
            opcode = Opcode.IPUT_OBJECT,
            smali = "Lcom/reddit/domain/model/listing/Listing;->children:Ljava/util/List;"
        ),
        fieldAccess(
            opcode = Opcode.IPUT_OBJECT,
            smali = "Lcom/reddit/domain/model/listing/Listing;->after:Ljava/lang/String;"
        ),
        fieldAccess(
            opcode = Opcode.IPUT_OBJECT,
            smali = "Lcom/reddit/domain/model/listing/Listing;->before:Ljava/lang/String;"
        )
    )
)

/**
 * Lcom/reddit/domain/model/listing/SubmittedListing;-><init>.
 * Class REMOVED in Reddit 2026.16.0+ — confirmed absent in 2026.42.0.
 * Kept so the patch can version-skip gracefully on older APKs.
 */
object SubmittedListingFingerprint : Fingerprint(
    definingClass = "Lcom/reddit/domain/model/listing/SubmittedListing;",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.CONSTRUCTOR),
    filters = listOf(
        fieldAccess(
            opcode = Opcode.IPUT_OBJECT,
            smali = "Lcom/reddit/domain/model/listing/SubmittedListing;->children:Ljava/util/List;"
        ),
        fieldAccess(
            opcode = Opcode.IPUT_OBJECT,
            smali = "Lcom/reddit/domain/model/listing/SubmittedListing;->videoUploads:Ljava/util/List;"
        ),
        fieldAccess(
            opcode = Opcode.IPUT_OBJECT,
            smali = "Lcom/reddit/domain/model/listing/SubmittedListing;->after:Ljava/lang/String;"
        )
    )
)

/**
 * CommentsAdState.toString() (2026.04+; class = Lria; in 2026.42.0).
 * `adsLoadCompleted` (field ->h:Z here) gates comment-ad placeholder rendering.
 */
object CommentsAdStateToStringFingerprint : Fingerprint(
    name = "toString",
    returnType = "Ljava/lang/String;",
    filters = listOf(
        string("CommentsAdState(conversationAdViewState="),
        string(", adsLoadCompleted="),
    )
)

/**
 * CommentsViewModel comment-ad loader — P(ZLcbc;I)V in 2026.42.0.
 * Signature: public final, (Z, L…, I) → V, constructs the ad loader La0a;
 * via invoke-direct <init>(Z, I)V.
 */
object CommentsViewModelAdLoaderFingerprint : Fingerprint(
    definingClass = "Lcom/reddit/comments/presentation/CommentsViewModel;",
    returnType = "V",
    accessFlags = listOf(AccessFlags.PUBLIC, AccessFlags.FINAL),
    parameters = listOf("Z", "L", "I"),
    filters = listOf(
        methodCall(
            opcode = Opcode.INVOKE_DIRECT,
            name = "<init>",
            parameters = listOf("Z", "I"),
            returnType = "V"
        )
    )
)
