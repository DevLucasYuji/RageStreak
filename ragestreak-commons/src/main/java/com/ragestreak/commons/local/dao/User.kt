package com.ragestreak.commons.local.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    private val id: String,
    private val firstTime: Boolean
)