package com.example.ragestreak.modules

import com.example.ragestreak.core.remote.Api
import com.example.ragestreak.core.remote.ApiContract
import com.example.ragestreak.core.remote.ApiHelper
import org.koin.dsl.bind
import org.koin.dsl.module

val coreModules = module {
    single { Api.Factory.newInstance<Api>() } bind ApiContract::class
    single { ApiHelper(get()) } bind ApiContract::class
}