package com.ragestreak.commons.modules

import com.ragestreak.commons.remote.GeneralApi
import com.ragestreak.commons.remote.GeneralApiContract
import com.ragestreak.commons.remote.GeneralApiHelper
import org.koin.dsl.bind
import org.koin.dsl.module

val coreModules = module {
    single { GeneralApi.Factory.newInstance<GeneralApi>() } bind GeneralApiContract::class
    single { GeneralApiHelper(get()) } bind GeneralApiContract::class
}