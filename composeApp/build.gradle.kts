import org.jetbrains.kotlin.gradle.plugin.mpp.Framework
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kmm)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.compose)
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
            baseName = "Integration"
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            api(project(":data-api"))
            api(project(":data-impl"))
            api(project(":domain-api"))
            api(project(":domain-impl"))
            api(project(":entity"))

            implementation(libs.voyager.navigator)
            implementation(libs.voyager.koin)
            implementation(libs.koin.core)
            implementation(libs.ktorfit.lib)
            implementation(libs.keyValue)
            implementation(libs.logging.napier)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.ui)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
        }
    }

    targets.withType<KotlinNativeTarget> {
        binaries.withType<Framework> {
            baseName = "ComposeApp"
            isStatic = true
            linkerOpts.add("-lsqlite3")

            export(project(":data-api"))
            export(project(":data-impl"))
            export(project(":domain-api"))
            export(project(":domain-impl"))
        }
    }
}

android {
    namespace = "com.kmm.compose"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "com.kmm.compose"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtension.get()
    }
    dependencies {
        implementation(libs.compose.ui.tooling.preview)
        debugImplementation(libs.compose.ui.tooling)
    }
}
