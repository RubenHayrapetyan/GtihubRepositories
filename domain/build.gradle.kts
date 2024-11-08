plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.jetbrains.kotlin.android)
  alias(libs.plugins.hilt.android)
  alias(libs.plugins.ksp)
}

android {
  namespace = "com.test.domain"
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
  implementation(project(":entity"))

  implementation(libs.hilt.android)
  ksp(libs.hilt.compiler)
  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.material)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)

  // JUnit 5 (or JUnit 4)
  testImplementation ("org.junit.jupiter:junit-jupiter-api:5.10.1") // TODO move to toml
  testImplementation ("org.junit.jupiter:junit-jupiter-engine:5.10.1")

// For using MockK in unit tests
  testImplementation ("io.mockk:mockk:1.13.3")
  testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.0")
// Coroutine support for test context
  testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")
// Optional for assertion (assertions like `assertThat`)
  testImplementation ("org.assertj:assertj-core:3.24.2")
}