package com.tardigrada.pojistiseapp.entities.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tardigrada.pojistiseapp.entities.AppDatabase
import com.tardigrada.pojistiseapp.entities.User
import com.tardigrada.pojistiseapp.entities.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val readAllUsersData: LiveData<List<User>>
    private val userRepository: UserRepository

    init {
        val userDao = AppDatabase.getInstance(application).userDao
        userRepository = UserRepository(userDao)
        readAllUsersData = userRepository.readAllUsers()
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.addUser(user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.updateUser(user)
        }
    }

    fun readAllData(): LiveData<List<User>> {
        return userRepository.readAllUsers()
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.deleteUser(user)
        }
    }
}