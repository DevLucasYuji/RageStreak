package com.ragestreak.commons.modules

import androidx.room.Room
import com.ragestreak.commons.local.RageDatabase
import com.ragestreak.commons.remote.GeneralApi
import com.ragestreak.commons.remote.GeneralApiContract
import com.ragestreak.commons.remote.GeneralApiHelper
import org.koin.dsl.bind
import org.koin.dsl.module

private const val db = "ragestreakdb"

val coreModules = module {
    single { GeneralApi.Factory.newInstance<GeneralApi>() } bind GeneralApiContract::class
    single { GeneralApiHelper(get()) } bind GeneralApiContract::class
    single { Room.databaseBuilder(get(), RageDatabase::class.java, db).build() } bind RageDatabase::class
}