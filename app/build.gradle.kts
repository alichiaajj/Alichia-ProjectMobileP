// Plugin Android dan Kotlin untuk mengompilasi aplikasi.
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

// Identitas aplikasi, versi SDK, dan pengaturan kompilasi.
android {
    namespace = "com.civicpulse.app"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.civicpulse.app"
        minSdk = 26
        targetSdk = 35
        versionCode = 5
        versionName = "4.1"
    }
    // Materi modul: kelas binding dibuat otomatis dari layout XML.
    buildFeatures { viewBinding = true }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }
}

// Library Android serta Glide yang digunakan pada modul praktikum.
dependencies {
    // Pertemuan 9: menu petak, halaman geser, dan penanda titik tutorial.
    implementation("androidx.gridlayout:gridlayout:1.0.0")
    implementation("androidx.viewpager2:viewpager2:1.1.0")
    implementation("com.tbuonomo:dotsindicator:5.1.0")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.fragment:fragment-ktx:1.8.5")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.2.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")
}
