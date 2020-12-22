package com.ragestreak.home.usecase

import com.ragestreak.commons.local.dao.UserDAO
import com.ragestreak.commons.local.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WelcomeUseCase(private val userDAO: UserDAO) {

    suspend fun userIsReady() = withContext(Dispatchers.IO) {
        val user = userDAO.getUser()?.copy(firstTime = false) ?: User(0, false).also {
            userDAO.createUser(it)
        }
        userDAO.updateUser(user)
    }
}
