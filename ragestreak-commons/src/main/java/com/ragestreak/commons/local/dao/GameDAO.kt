package com.ragestreak.commons.local.dao

import androidx.room.*
import com.ragestreak.commons.local.model.Game

@Dao
interface GameDAO {

    @Query("SELECT * FROM games")
    fun getAll(): List<Game>

    @Update
    fun update(game: Game)

    @Delete
    fun deleteGame(game: Game)

    @Insert
    fun createGame(game: Game)
}