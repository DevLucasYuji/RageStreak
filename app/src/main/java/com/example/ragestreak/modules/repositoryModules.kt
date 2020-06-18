package com.example.ragestreak.modules

import com.example.ragestreak.feature.home.repository.HomeRepository
import com.example.ragestreak.feature.home.repository.HomeRepositoryContract
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModules = module {
    single { HomeRepository(get()) } bind HomeRepositoryContract::class
}