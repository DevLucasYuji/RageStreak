package com.ragestreak.commons.local.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Rager(
    @PrimaryKey
    private val id: String,
    private val name: String,
    private val lastName: String,
    private val games: List<Game>,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private val picture: ByteArray? = null,

    )