package com.example.ragestreak.feature.home.repository

import com.example.ragestreak.feature.home.models.Profile

interface HomeRepositoryContract {
    fun getProfiles(): List<Profile>
}
