plugins {
    alias(libs.plugins.ksp)
    alias(libs.plugins.kmm)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.ktorfit)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "DataImpl"
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":entity"))
            implementation(project(":data-api"))

            implementation(libs.coroutines.core)
            implementation(libs.ktorfit.lib)
            implementation(libs.ktor.contentNegotiation)
            implementation(libs.ktor.json)
            implementation(libs.ktor.auth)
            implementation(libs.keyValue)

        }
        dependencies {
            add("kspCommonMainMetadata", libs.ktorfit.ksp)
            add("kspAndroid", libs.ktorfit.ksp)
            add("kspIosX64", libs.ktorfit.ksp)
            add("kspIosArm64", libs.ktorfit.ksp)
            add("kspIosSimulatorArm64", libs.ktorfit.ksp)
        }
    }
}

android {
    namespace = "com.kmm.compose.data"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }
}
