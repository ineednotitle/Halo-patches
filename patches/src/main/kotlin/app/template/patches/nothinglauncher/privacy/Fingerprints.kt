package app.template.patches.nothinglauncher.privacy

import app.morphe.patcher.Fingerprint

/**
 * FcmSdkHelper.b() — uploads Firebase Analytics custom user properties
 * ("nothing_os_version", "nothing_os_build_number") built from the ROM's
 * Nothing-OS version/build strings. Called once from
 * NTLauncherApplication.onCreate. Unique in its class by both marker strings.
 */
internal val FcmSdkHelperUploadUserPropertiesFingerprint = Fingerprint(
    definingClass = "Lr3/c;",
    name = "b",
    returnType = "V",
    parameters = emptyList(),
    strings = listOf("nothing_os_version", "nothing_os_build_number"),
)
