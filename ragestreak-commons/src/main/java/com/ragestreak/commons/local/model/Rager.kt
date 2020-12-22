package com.ragestreak.commons.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ragers")
data class Rager(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val lastName: String,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    val picture: ByteArray? = null,
)