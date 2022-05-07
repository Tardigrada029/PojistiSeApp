package com.tardigrada.pojistiseapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_user")
data class User (
    @PrimaryKey(autoGenerate = true)
    val userId: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
)