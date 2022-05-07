package com.tardigrada.pojistiseapp.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.tardigrada.pojistiseapp.entities.Insurance
import com.tardigrada.pojistiseapp.entities.Product

data class ProductWithInsurances(
    @Embedded val product: Product,
    @Relation(
        parentColumn = "productId",
        entityColumn = "productId"
    )

    val insurances: List<Insurance>
)