package com.tardigrada.pojistiseapp.entities.dao

import androidx.room.*
import com.tardigrada.pojistiseapp.entities.Insurance
import com.tardigrada.pojistiseapp.entities.relations.ProductWithInsurances
import com.tardigrada.pojistiseapp.entities.relations.UserWithInsurances

@Dao
interface InsuranceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInsurance(insurance: Insurance)

    @Transaction
    @Query("SELECT * FROM table_insurance")
    suspend fun getAllInsurances(): List<Insurance>

    @Transaction
    @Query("SELECT * FROM table_user WHERE userId = :userId")
    suspend fun getUserWithInsurances(userId: Int): List<UserWithInsurances>

    @Transaction
    @Query("SELECT * FROM table_product WHERE productId = :productId")
    suspend fun getProductWithInsurances(productId: Int): List<ProductWithInsurances>
}