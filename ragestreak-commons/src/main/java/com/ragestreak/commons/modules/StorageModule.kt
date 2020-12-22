package com.ragestreak.commons.modules

import org.koin.core.module.Module

interface StorageModule {
    fun addModules(vararg module: Module)
}
