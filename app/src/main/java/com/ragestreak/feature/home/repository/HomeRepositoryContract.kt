package com.ragestreak.feature.home.repository

import com.ragestreak.feature.home.models.Profile

interface HomeRepositoryContract {
    fun getProfiles(): List<Profile>
}
