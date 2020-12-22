package com.ragestreak.commons.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ragers")
data class Rager(
    @PrimaryKey(autoGenerate = true)
    private val id: Long,
    private val name: String,
    private val lastName: String,
    private val games: List<Game>,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private val picture: ByteArray? = null,
)