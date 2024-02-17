rootProject.name = "kmmCompose"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

include(":composeApp")

val sourcesDir = File("sources")
sourcesDir.list()?.forEach {
    include(":$it")
    project(":$it").apply {
        projectDir = File(sourcesDir, it)
        buildFileName = "$it.gradle.kts"
    }
}
include(":lib")
