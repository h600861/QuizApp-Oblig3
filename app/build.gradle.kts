plugins {
    id ("com.android.application")
}

android {
    namespace = "no.hvl.dat153.quizapp_oblig3"
    compileSdk = 34

    defaultConfig {
        applicationId = "no.hvl.dat153.quizapp_oblig3"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}


dependencies {
    implementation ("androidx.appcompat:appcompat:1.4.0")
    implementation ("com.google.android.material:material:1.5.0")
    implementation ("androidx.activity:activity-ktx:1.4.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.3")

    // Room database
    implementation ("androidx.room:room-runtime:2.4.0")
    annotationProcessor ("androidx.room:room-compiler:2.4.0")

    implementation ("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    // Testing dependencies
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}
