package com.tardigrada.pojistiseapp.entities.repositories

import com.tardigrada.pojistiseapp.entities.Product
import com.tardigrada.pojistiseapp.entities.dao.ProductDao

class ProductRepository(private val productDao: ProductDao) {

    suspend fun readAllProducts(): List<Product> {
        return productDao.getAllProducts()
    }

    suspend fun addProduct(product: Product) {
        productDao.insertProduct(product)
    }
}