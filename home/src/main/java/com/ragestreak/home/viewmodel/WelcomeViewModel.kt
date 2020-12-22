package com.ragestreak.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ragestreak.commons.BaseViewModel
import com.ragestreak.home.usecase.WelcomeUseCase
import com.ragestreak.home.viewmodel.states.WelcomeEvent
import kotlinx.coroutines.launch

class WelcomeViewModel(private val useCase: WelcomeUseCase) : BaseViewModel() {

    private val event: MutableLiveData<WelcomeEvent> = MutableLiveData()
    val viewEvent: LiveData<WelcomeEvent> = event

    fun onClickedReady() {
        viewModelScope.launch {
            useCase.userIsReady()
            event.postValue(WelcomeEvent.UserIsReady)
        }
    }
}
