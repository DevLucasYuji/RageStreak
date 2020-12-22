package com.ragestreak.commons.local.dao

import androidx.room.*
import com.ragestreak.commons.local.model.User

@Dao
interface UserDAO {

    @Query("SELECT * FROM users LIMIT 1")
    fun getUser(): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createUser(user: User)

    @Update
    fun updateUser(user: User)
}