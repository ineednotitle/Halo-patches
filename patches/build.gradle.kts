group = "app.doom.reddit-patches"

patches {
    about {
        name = "Doom's Reddit Patches"
        description = "New mask, same task. Doom's patches for the Reddit app."
        source = "https://github.com/YOUR_USERNAME/doom-reddit-patches"
        author = "YOUR_USERNAME"
        contact = "https://github.com/YOUR_USERNAME"
        website = "https://morphe.software/add-source?github=YOUR_USERNAME/doom-reddit-patches"
        license = "GPLv3"
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xcontext-parameters")
    }
}

// Separate configuration so gson is available at runtime for the
// generatePatchesList task but never bundled into the patch jar.
val patchListGeneratorClasspath: Configuration by configurations.creating

dependencies {
    compileOnly(libs.gson)
    patchListGeneratorClasspath(libs.gson)
}

tasks {
    register<JavaExec>("generatePatchesList") {
        description = "Build patch with patch list"

        dependsOn(build)

        classpath = sourceSets["main"].runtimeClasspath + patchListGeneratorClasspath
        mainClass.set("app.morphe.util.PatchListGeneratorKt")
    }

    // Used by gradle-semantic-release-plugin.
    publish {
        dependsOn("generatePatchesList")
    }
}
