package com.tardigrada.pojistiseapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "table_insurance")
data class Insurance (
    @PrimaryKey(autoGenerate = true)
    val insuranceId: Int,
    val value: Double,
    val userId: Int,
    val productId: Int
)