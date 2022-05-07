package com.tardigrada.pojistiseapp.entities.dao

import androidx.room.*
import com.tardigrada.pojistiseapp.entities.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Transaction
    @Query("SELECT * FROM table_user")
    suspend fun getAllUsers(): List<User>
}