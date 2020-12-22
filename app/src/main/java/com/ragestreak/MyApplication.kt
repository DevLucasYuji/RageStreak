package com.ragestreak

import android.app.Application
import android.content.Context
import com.ragestreak.commons.modules.coreModules
import com.google.android.play.core.splitcompat.SplitCompat
import com.ragestreak.commons.local.RageDatabase
import com.ragestreak.commons.local.model.User
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(coreModules)
        }

        val db: RageDatabase = get()
        val user =  db.userDAO().getUser()
        if(user == null) {
            db.userDAO().createUser(User(0, true))
        }
    }

    override fun attachBaseContext(context: Context?) {
        super.attachBaseContext(context)
        SplitCompat.install(this)
    }
}