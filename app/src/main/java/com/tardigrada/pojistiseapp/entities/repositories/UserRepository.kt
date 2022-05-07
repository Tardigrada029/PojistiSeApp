package com.tardigrada.pojistiseapp.entities.repositories

import com.tardigrada.pojistiseapp.entities.User
import com.tardigrada.pojistiseapp.entities.dao.UserDao

class UserRepository(private val userDao: UserDao) {

    suspend fun readAllUsers(): List<User> {
        return userDao.getAllUsers()
    }

    suspend fun addUser(user: User) {
        userDao.insertUser(user)
    }
}