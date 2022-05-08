package com.tardigrada.pojistiseapp.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName= "table_insurance")
data class Insurance (
    @PrimaryKey(autoGenerate = true)
    val insuranceId: Int,
    val value: Double,
    val userId: Int,
    val productId: Int
): Parcelable