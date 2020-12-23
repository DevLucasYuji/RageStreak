package com.ragestreak.home.viewmodel.states

sealed class HomeEvent {
    object NavigateToWelcome: HomeEvent()
    object UserIsReady : HomeEvent()
}
