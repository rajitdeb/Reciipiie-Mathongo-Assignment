package com.rajit.reciipiie_mathongoassignment

import android.app.Application
import com.rajit.reciipiie_mathongoassignment.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // koin initialization
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule)
        }

    }

}