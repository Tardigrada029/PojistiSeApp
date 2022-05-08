package com.tardigrada.pojistiseapp.entities.repositories

import androidx.lifecycle.LiveData
import com.tardigrada.pojistiseapp.entities.Product
import com.tardigrada.pojistiseapp.entities.dao.ProductDao

class ProductRepository(private val productDao: ProductDao) {

    fun readAllProducts(): LiveData<List<Product>> {
        return productDao.getAllProducts()
    }

    suspend fun addProduct(product: Product) {
        productDao.insertProduct(product)
    }

    suspend fun updateProduct(product: Product) {
        productDao.updateProduct(product)
    }

    suspend fun deleteProduct(product: Product) {
        productDao.deleteProduct(product)
    }
}