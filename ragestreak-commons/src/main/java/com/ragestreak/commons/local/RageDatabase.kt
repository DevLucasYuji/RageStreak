package com.ragestreak.commons.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ragestreak.commons.local.dao.GameDAO
import com.ragestreak.commons.local.dao.RagerDAO
import com.ragestreak.commons.local.dao.UserDAO
import com.ragestreak.commons.local.model.Game
import com.ragestreak.commons.local.model.Rager
import com.ragestreak.commons.local.model.User

@Database(entities = [User::class, Rager::class, Game::class], version = 1, exportSchema = false)
abstract class RageDatabase : RoomDatabase() {
    abstract fun userDAO(): UserDAO

    abstract fun ragerDAO(): RagerDAO

    abstract fun gameDAO(): GameDAO
}