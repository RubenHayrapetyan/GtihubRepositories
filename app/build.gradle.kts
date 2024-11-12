plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.jetbrains.kotlin.android)
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
}

dependencies {
  implementation(project(":presentation"))
  implementation(project(":data"))
  implementation(project(":domain"))

  implementation(libs.hilt.android)
  ksp(libs.hilt.compiler)
}