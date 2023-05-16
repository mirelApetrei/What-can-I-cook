package com.example.whatcanicook

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication: Application() {

  /*  override fun onCreate() {
        super.onCreate()

        // Initialize Dagger Hilt
        DaggerMyApplicationComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }*/

}