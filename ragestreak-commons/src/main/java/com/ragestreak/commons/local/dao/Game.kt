package com.ragestreak.commons.local.dao

import androidx.room.PrimaryKey

data class Game(
    @PrimaryKey
    private val id: String,
    private val name: String,
    private val quantity: Int,
    private val winQuantity: Int,
    private val loseQuantity: Int,
    private val ragerQuantity: Int,
    private val ragerId: String
)
