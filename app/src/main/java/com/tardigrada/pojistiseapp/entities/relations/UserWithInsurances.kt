package com.tardigrada.pojistiseapp.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.tardigrada.pojistiseapp.entities.Insurance
import com.tardigrada.pojistiseapp.entities.User

data class UserWithInsurances(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "userId"
    )

    val Insurances: List<Insurance>
)