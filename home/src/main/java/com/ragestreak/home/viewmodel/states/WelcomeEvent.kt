package com.ragestreak.home.viewmodel.states

sealed class WelcomeEvent {
    object UserIsReady : WelcomeEvent()
}
