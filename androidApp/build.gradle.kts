plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hilt)
//    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinKapt)
    alias(libs.plugins.sqldelight)
}

android {
    namespace = "com.compose.noteapp.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.compose.noteapp.android"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)

    implementation(libs.kotlinx.datetime.v040)

    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt.navigation.compose)

    kapt(libs.hilt.android.compiler)
    kapt(libs.androidx.hilt.compiler)
}