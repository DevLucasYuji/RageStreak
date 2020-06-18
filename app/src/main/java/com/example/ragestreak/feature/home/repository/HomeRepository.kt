package com.example.ragestreak.feature.home.repository

import com.example.ragestreak.feature.home.models.Profile

class HomeRepository(private val api: Any): HomeRepositoryContract {

    override fun getProfiles(): List<Profile> {

        return listOf()
    }
}