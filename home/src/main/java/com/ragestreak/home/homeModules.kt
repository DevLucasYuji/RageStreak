package com.ragestreak.home

import com.ragestreak.home.usecase.HomeUseCase
import com.ragestreak.home.usecase.WelcomeUseCase
import com.ragestreak.home.viewmodel.HomeViewModel
import com.ragestreak.home.viewmodel.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val homeModules = module {
    // Home
    single { HomeUseCase(get()) }
    viewModel { HomeViewModel(get()) }

    // Welcome
    single { WelcomeUseCase(get()) }
    viewModel { WelcomeViewModel(get()) }
}