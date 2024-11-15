plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.jetbrains.kotlin.android)
  alias(libs.plugins.hilt.android)
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.test.data"
  compileSdk = 35

  defaultConfig {
    minSdk = 23

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
  }
}

dependencies {
  implementation(project(":domain"))
  implementation(project(":core"))

  implementation(libs.hilt.android)
  implementation (libs.retrofit2.converter.moshi)
  ksp(libs.hilt.compiler)
  implementation (libs.retrofit)
  testImplementation(libs.junit)
}