package com.tardigrada.pojistiseapp.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "table_user")
data class User (
    @PrimaryKey(autoGenerate = true)
    val userId: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
): Parcelable