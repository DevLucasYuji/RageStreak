package com.example.ragestreak

import android.app.Application
import com.example.ragestreak.modules.coreModules
import com.example.ragestreak.modules.repositoryModules
import com.example.ragestreak.modules.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(
                coreModules,
                repositoryModules,
                viewModelModules
            )
        }
    }
}