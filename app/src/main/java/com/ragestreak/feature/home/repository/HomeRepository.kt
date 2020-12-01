package com.ragestreak.feature.home.repository

import com.ragestreak.feature.home.models.Profile

class HomeRepository(private val api: Any): HomeRepositoryContract {

    override fun getProfiles(): List<Profile> {

        return listOf()
    }
}