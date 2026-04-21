plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.estibenlicona.samsungtvremote"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.estibenlicona.samsungtvremote"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    signingConfigs {
        create("release") {
            val storeFilePath = System.getenv("SIGNING_STORE_FILE")
            val storePass = System.getenv("SIGNING_STORE_PASSWORD")
            val keyAliasEnv = System.getenv("SIGNING_KEY_ALIAS")
            val keyPassEnv = System.getenv("SIGNING_KEY_PASSWORD")
            if (!storeFilePath.isNullOrBlank() && !storePass.isNullOrBlank()
                && !keyAliasEnv.isNullOrBlank() && !keyPassEnv.isNullOrBlank()
            ) {
                storeFile = file(storeFilePath)
                storePassword = storePass
                keyAlias = keyAliasEnv
                keyPassword = keyPassEnv
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            val hasSigningEnv =
                !System.getenv("SIGNING_STORE_FILE").isNullOrBlank() &&
                    !System.getenv("SIGNING_STORE_PASSWORD").isNullOrBlank() &&
                    !System.getenv("SIGNING_KEY_ALIAS").isNullOrBlank() &&
                    !System.getenv("SIGNING_KEY_PASSWORD").isNullOrBlank()
            if (hasSigningEnv) {
                signingConfig = signingConfigs.getByName("release")
            }
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
