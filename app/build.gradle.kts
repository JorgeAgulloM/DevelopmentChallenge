import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.softyorch.retosdeprogramacion"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.softyorch.retosdeprogramacion"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

/*        android.buildFeatures.buildConfig = true
        val projectProperties = readProperties(file("../apikeys.properties"))
        buildConfigField("String", "MARVEL_PRIVATE_API_KEY", projectProperties["MARVEL_PRIVATE_API_KEY"] as String)
        buildConfigField("String", "MARVEL_PUBLIC_API_KEY", projectProperties["MARVEL_PUBLIC_API_KEY"] as String)*/
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

/*fun readProperties(propertiesFile: File) = Properties().apply {
    propertiesFile.inputStream().use { fis ->
        load(fis)
    }
}*/

dependencies {

    // https://central.sonatype.dev/artifact/org.eclipse.jgit/org.eclipse.jgit/
    implementation("org.eclipse.jgit:org.eclipse.jgit:6.4.0.202211300538-r")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}