package com.ragestreak

import android.app.Application
import android.content.Context
import com.ragestreak.commons.modules.coreModules
import com.google.android.play.core.splitcompat.SplitCompat
import com.ragestreak.commons.local.RageDatabase
import com.ragestreak.commons.local.model.User
import com.ragestreak.commons.modules.StorageModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

class MyApplication : Application(), StorageModule {

    private val modules: MutableList<Module> = mutableListOf()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(coreModules)
        }

        CoroutineScope(Dispatchers.IO).launch {
            val db: RageDatabase = get()
            val user = db.userDAO().getUser()
            if (user == null) {
                db.userDAO().createUser(User(0, true))
            }
        }
    }

    override fun attachBaseContext(context: Context?) {
        super.attachBaseContext(context)
        SplitCompat.install(this)
    }

    override fun addModules(vararg module: Module) {
        val modules = mutableListOf(*module)
        val distinctModules = modules.filter { !this.modules.contains(it) }
        if (distinctModules.isNotEmpty()) {
            loadKoinModules(distinctModules)
        }
    }
}