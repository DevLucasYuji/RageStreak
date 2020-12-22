package com.ragestreak.home.usecase

import com.ragestreak.commons.local.dao.UserDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeUseCase(private val userDAO: UserDAO) {

    suspend fun isFirstTime(): Boolean = withContext(Dispatchers.IO) {
        userDAO.getUser()?.firstTime ?: false
    }
}
