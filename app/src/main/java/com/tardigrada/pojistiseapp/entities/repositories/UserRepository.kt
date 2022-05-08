package com.tardigrada.pojistiseapp.entities.repositories

import androidx.lifecycle.LiveData
import com.tardigrada.pojistiseapp.entities.User
import com.tardigrada.pojistiseapp.entities.dao.UserDao

class UserRepository(private val userDao: UserDao) {

    fun readAllUsers(): LiveData<List<User>> {
        return userDao.getAllUsers()
    }

    suspend fun addUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }
}