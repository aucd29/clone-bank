package com.example.clone_bank

import android.app.Application
import android.util.Log
import brigitte.core.di.module.TimberConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class MainApp : Application() {
    @Inject
    lateinit var timerConfig: TimberConfig

    override fun onCreate() {
        super.onCreate()

        timerConfig.setting(BuildConfig.DEBUG)

        Log.w("[bk]", "==== HELLO ====")
    }
}