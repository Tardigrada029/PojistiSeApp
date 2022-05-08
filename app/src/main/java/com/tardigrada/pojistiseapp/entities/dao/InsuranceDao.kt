package com.tardigrada.pojistiseapp.entities.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tardigrada.pojistiseapp.entities.Insurance
// import com.tardigrada.pojistiseapp.entities.relations.ProductWithInsurances
// import com.tardigrada.pojistiseapp.entities.relations.UserWithInsurances

@Dao
interface InsuranceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInsurance(insurance: Insurance)

    @Update
    suspend fun updateInsurance(insurance: Insurance)

    @Transaction
    @Query("SELECT * FROM table_insurance")
    fun getAllInsurances(): LiveData<List<Insurance>>

    /*
    @Transaction
    @Query("SELECT * FROM table_user WHERE userId = :userId")
    fun getUserWithInsurances(userId: Int): LiveData<List<UserWithInsurances>>

    @Transaction
    @Query("SELECT * FROM table_product WHERE productId = :productId")
    fun getProductWithInsurances(productId: Int): LiveData<List<ProductWithInsurances>>

     */
}