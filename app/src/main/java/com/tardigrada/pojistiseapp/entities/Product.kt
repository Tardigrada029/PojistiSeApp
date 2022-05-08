package com.tardigrada.pojistiseapp.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "table_product")
data class Product (
    @PrimaryKey(autoGenerate = true)
    val productId: Int,
    val productName: String
): Parcelable