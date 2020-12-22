package com.ragestreak.commons.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class Game(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val quantity: Int,
    val winQuantity: Int,
    val loseQuantity: Int,
    val ragerQuantity: Int,
    val ragerId: Long
)
