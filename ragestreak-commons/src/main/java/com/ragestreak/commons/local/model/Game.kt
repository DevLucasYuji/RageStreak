package com.ragestreak.commons.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class Game(
    @PrimaryKey(autoGenerate = true)
    private var id: Long,
    private var name: String,
    private var quantity: Int,
    private var winQuantity: Int,
    private var loseQuantity: Int,
    private var ragerQuantity: Int,
    private var ragerId: Long
)
