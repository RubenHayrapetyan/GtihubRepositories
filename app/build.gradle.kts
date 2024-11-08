plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.jetbrains.kotlin.android)
  alias(libs.plugins.compose.compiler)
  alias(libs.plugins.hilt.android)
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.test.githubrepositories"
  compileSdk = 35

  defaultConfig {
    applicationId = "com.test.githubrepositories"
    minSdk = 23
    targetSdk = 35
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
  composeOptions {
    kotlinCompilerExtensionVersion = "1.5.15"
  }
  buildFeatures {
    compose = true
  }
}

dependencies {
  implementation(project(":presentation"))
  implementation(project(":data"))
  implementation(project(":domain"))
  implementation(project(":entity"))

  implementation (libs.jsoup) // TODO
  implementation (libs.androidx.navigation.compose)
  implementation (libs.retrofit)
  implementation (libs.retrofit2.converter.moshi)
  implementation (libs.logging.interceptor)
  implementation(libs.androidx.lifecycle.runtime.ktx.v270)
  implementation (libs.androidx.lifecycle.viewmodel.ktx)
  implementation(libs.androidx.activity.compose.v182)
  implementation(libs.hilt.android)
  ksp(libs.hilt.compiler)
  implementation (libs.hilt.navigation.compose)
  implementation(libs.coil.compose)
  implementation(libs.androidx.core.ktx)
  implementation(platform(libs.androidx.compose.bom))
  implementation(libs.androidx.ui)
  implementation(libs.androidx.ui.graphics)
  implementation(libs.androidx.ui.tooling.preview)
  implementation(libs.androidx.material3)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
  androidTestImplementation(platform(libs.androidx.compose.bom))
  androidTestImplementation(libs.androidx.ui.test.junit4)
  debugImplementation(libs.androidx.ui.tooling) // TODO
  debugImplementation(libs.androidx.ui.test.manifest)
}