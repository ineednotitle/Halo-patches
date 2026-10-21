package app.template.patches.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

/**
 * Central registry of app compatibilities (Doom's pattern: every patch references a
 * constant from here so version bumps happen in exactly one place).
 *
 * Signing-certificate SHA-256 for the official Reddit APK — lets Morphe Manager tell
 * the user when they picked a repacked/tampered APK. Same value the official
 * MorpheApp/morphe-patches repo lists for com.reddit.frontpage.
 *
 * Reddit ships on the Play Store as an App Bundle → always grab an APKM/APKS mirror,
 * hence ApkFileType.APKM.
 */
object Constants {

    val REDDIT_COMPATIBILITY = Compatibility(
        name = "Reddit",
        packageName = "com.reddit.frontpage",
        apkFileType = ApkFileType.APKM,
        appIconColor = 0xFF4500,
        signatures = setOf(
            "970b91143813b4c9d5f3634f672c9fcaa5621b4efaaedafd6c235cbbb869736f"
        ),
        targets = listOf(
            AppTarget(
                version = "2026.42.0",
                minSdk = 29,
                isExperimental = true
            ),
            AppTarget(
                version = "2026.41.0",
                minSdk = 29,
                isExperimental = true
            ),
            AppTarget(
                version = "2026.40.0",
                minSdk = 29,
                isExperimental = true
            ),
            AppTarget(
                version = "2026.39.0",
                minSdk = 29,
                isExperimental = true
            ),
            AppTarget(
                version = "2026.24.0", // Last version with disable modern home.
                minSdk = 29
            ),
            AppTarget(
                version = "2026.10.0", // Last version for Android 9.0
                minSdk = 28
            )
        )
    )
}
