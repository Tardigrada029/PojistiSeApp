package com.tardigrada.pojistiseapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_product")
data class Product (
    @PrimaryKey(autoGenerate = true)
    val productId: Int,
    val productName: String
)