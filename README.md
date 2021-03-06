# Basic-Setting-MVVM-HILT

This is just basic example for setting up MVVM design pattern with HILT, Retrofit, databinded recyclerView
- I will post later for the room database and the mapper function to it

Libraries List:
    
    Project Gradle
    
        dependencies {
        //hilt
        classpath 'com.google.dagger:hilt-android-gradle-plugin:2.38.1'
        }
        
    Module Gradle
        
        plugins {
        id 'com.android.application'
        id 'kotlin-android'

        //hilt
        id 'kotlin-kapt'
        id 'dagger.hilt.android.plugin'
        }
        
        compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
         }
         
        kotlinOptions {
        jvmTarget = '1.8'
        }

            //databinding
        buildFeatures {
            viewBinding true
            dataBinding true
        }
        
        dependencies {

            implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
            implementation 'androidx.core:core-ktx:1.7.0'
            implementation 'androidx.appcompat:appcompat:1.3.1'
            implementation 'com.google.android.material:material:1.4.0'
            implementation 'androidx.constraintlayout:constraintlayout:2.1.1'
            implementation 'androidx.navigation:navigation-fragment-ktx:2.3.5'
            implementation 'androidx.navigation:navigation-ui-ktx:2.3.5'
            testImplementation 'junit:junit:4.+'
            androidTestImplementation 'androidx.test.ext:junit:1.1.3'
            androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
            //Activity KTX for viewModels()
            implementation "androidx.activity:activity-ktx:1.4.0"

            // ViewModel
            def lifecycle_version = "2.4.0"
            implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"

            // Compose dependencies- not needed for this project
            implementation "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
            implementation "androidx.navigation:navigation-compose:2.4.0-alpha08"
            implementation "com.google.accompanist:accompanist-flowlayout:0.17.0"

            // Coroutines
            implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1'
            implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1'

            // Coroutine Lifecycle Scopes
            implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0"
            implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"

            // LiveData
            implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"

            //Dagger - Hilt
            implementation "com.google.dagger:hilt-android:2.37"
            kapt "com.google.dagger:hilt-android-compiler:2.37"
            implementation 'androidx.hilt:hilt-navigation-compose:1.0.0-alpha03'

            //Retrofit
            implementation 'com.squareup.retrofit2:retrofit:2.9.0'
            implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
            implementation "com.squareup.okhttp3:okhttp:5.0.0-alpha.2"
            implementation "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2"

            //glide
            implementation 'com.github.bumptech.glide:glide:4.12.0'
            annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'

            }


