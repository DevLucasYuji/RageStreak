package com.ragestreak.commons.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    private val id: Long,
    private var firstTime: Boolean
)