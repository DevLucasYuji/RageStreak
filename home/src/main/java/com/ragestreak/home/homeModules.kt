package com.ragestreak.home

import com.ragestreak.home.usecase.HomeUseCase
import com.ragestreak.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val homeModules = module {
    single { HomeUseCase(get()) }
    viewModel { HomeViewModel(get()) }
}