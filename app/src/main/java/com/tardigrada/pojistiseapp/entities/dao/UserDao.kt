package com.tardigrada.pojistiseapp.entities.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tardigrada.pojistiseapp.entities.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Transaction
    @Query("SELECT * FROM table_user")
    fun getAllUsers(): LiveData<List<User>>
}