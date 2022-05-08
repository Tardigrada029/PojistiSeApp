package com.tardigrada.pojistiseapp.entities.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tardigrada.pojistiseapp.entities.Product

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product)

    @Update
    suspend fun updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Transaction
    @Query("SELECT * FROM table_product")
    fun getAllProducts(): LiveData<List<Product>>
}