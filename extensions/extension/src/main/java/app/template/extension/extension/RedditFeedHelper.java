package app.template.extension.extension;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * RedditFeedHelper — runtime ad-filter invoked from smali injected by
 * app.template.patches.reddit.removeads.RemoveAdsPatch.
 *
 * Why reflection instead of importing com.reddit.domain.model.ILink:
 * the extension compiles against the Android SDK only. Reflection on the
 * merged app's own classes avoids stuffing stub classes into the bundle.
 * Method lookups are cached per concrete class, so repeated feed renders
 * cost one map hit + one trivial boolean invoke each.
 *
 * Contract expected by the patch (must stay in sync):
 *   hideOldPostAds(List)  → same or shorter list (promoted items removed)
 *   hideNewPostAds(List)  → null  (patch substitutes an empty immutable list)
 *   hideCommentAds()      → true
 *   hideCommentAds(Z)Z    → true (OR with original)
 */
public final class RedditFeedHelper {

    /**
     * Per-class cache of the no-arg boolean "promoted" accessor.
     * Optional.empty means the class has no promoted flag (regular content).
     * NOTE: ConcurrentHashMap cannot store null values — the previous revision
     * threw NullPointerException on cache.put(cls, null) for any row class
     * without a promoted getter, then re-threw two NoSuchMethodExceptions
     * (each with stack-fill overhead) on every subsequent frame. Optional
     * storage makes the warmed path exception-free for all row shapes.
     */
    private static final Map<Class<?>, Optional<Method>> PROMOTED_GETTER_CACHE =
            new ConcurrentHashMap<>();

    private static final String[] PROMOTED_GETTER_NAMES = { "getPromoted", "isPromoted" };

    private RedditFeedHelper() {
        // Static injection surface only.
    }

    /**
     * Injection point — old-style feed listings (Listing / SubmittedListing
     * `children`). Drops every item whose promoted flag reads true, keeps
     * everything else bit-identical.
     */
    public static List<?> hideOldPostAds(List<?> list) {
        if (list == null || list.isEmpty()) {
            return list;
        }

        List<Object> filtered = null;
        for (int i = 0, size = list.size(); i < size; i++) {
            Object item = list.get(i);
            if (isPromoted(item)) {
                if (filtered == null) {
                    // Copy-on-first-ad: most screens are ad-free after layer 3
                    // anyway, so avoid allocating until an ad actually shows up.
                    filtered = new ArrayList<>(list.subList(0, i));
                }
                continue;
            }
            if (filtered != null) {
                filtered.add(item);
            }
        }

        return filtered != null ? filtered : list;
    }

    /**
     * Injection point — new-feed AdPostSection sections list.
     * Returning null tells the patch smali to substitute an empty
     * immutable list (sections are rebuilt from scratch without ad slots).
     */
    public static List<?> hideNewPostAds(List<?> list) {
        return null;
    }

    /**
     * Injection point — comment banner ad loader entry kill.
     */
    public static boolean hideCommentAds() {
        return true;
    }

    /**
     * Injection point — CommentsAdState.adsLoadCompleted force-true, OR'd with
     * the original constructor value so behavior degrades gracefully if this
     * helper is ever neutralized.
     */
    public static boolean hideCommentAds(boolean original) {
        return true || original;
    }

    /**
     * True when [item] is a Reddit feed element whose promoted flag is set.
     * Handles both getter spellings Kotlin emits for `val promoted` /
     * `val isPromoted` and the ILink interface accessor `getPromoted()`.
     */
    private static boolean isPromoted(Object item) {
        if (item == null) {
            return false;
        }

        Class<?> cls = item.getClass();
        Optional<Method> getter = PROMOTED_GETTER_CACHE
                .computeIfAbsent(cls, RedditFeedHelper::findPromotedGetter);
        if (!getter.isPresent()) {
            return false;
        }

        try {
            Object result = getter.get().invoke(item);
            return Boolean.TRUE.equals(result);
        } catch (Throwable ignored) {
            // Item shape drifted (new Reddit build): treat as regular content
            // rather than crashing the feed.
            return false;
        }
    }

    private static Optional<Method> findPromotedGetter(Class<?> cls) {
        for (String name : PROMOTED_GETTER_NAMES) {
            try {
                Method m = cls.getMethod(name);
                if (m.getParameterCount() == 0 &&
                        (m.getReturnType() == boolean.class || m.getReturnType() == Boolean.class)) {
                    m.setAccessible(true);
                    return Optional.of(m);
                }
            } catch (NoSuchMethodException ignored) {
                // Try next spelling.
            }
        }
        return Optional.empty();
    }
}
