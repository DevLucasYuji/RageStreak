package com.ragestreak.commons.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ragestreak.commons.local.model.Rager

@Dao
interface RagerDAO {

    @Query("SELECT * FROM rager")
    fun getAll(): List<Rager>

    @Query("SELECT * FROM rager where id = :id")
    fun findRager(id: String): Rager

    @Insert
    fun createRager(rager: Rager)

    @Update
    fun updateRager(rager: Rager)
}