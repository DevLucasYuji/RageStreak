package com.ragestreak.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ragestreak.commons.BaseViewModel
import com.ragestreak.home.usecase.HomeUseCase
import com.ragestreak.home.viewmodel.states.HomeEvent
import kotlinx.coroutines.launch

class HomeViewModel(private val usecase: HomeUseCase) : BaseViewModel() {

    private val event: MutableLiveData<HomeEvent> = MutableLiveData()

    var viewEvent: LiveData<HomeEvent> = event

    fun init() {
        checkIfIsFirstTime()
    }

    private fun checkIfIsFirstTime() {
        viewModelScope.launch {
            val isFirstTime = usecase.isFirstTime()
            if(isFirstTime) {
                event.postValue(HomeEvent.NavigateToWelcome)
            } else {
                event.postValue(HomeEvent.UserIsReady)
            }
        }
    }
}
