plugins {
    alias(libs.plugins.kmm)
    alias(libs.plugins.androidLibrary)
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
            baseName = "DomainImpl"
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(project(":entity"))
            implementation(project(":data-api"))
            implementation(project(":domain-api"))
        }
    }
}

android {
    namespace = "com.kmm.compose.domain"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }
}
