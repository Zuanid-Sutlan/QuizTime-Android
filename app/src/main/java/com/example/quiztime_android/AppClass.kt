package com.example.quiztime_android

import android.app.Application
import com.example.quiztime_android.di.koinModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppClass: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppClass)
            modules(koinModule)
        }
    }

}