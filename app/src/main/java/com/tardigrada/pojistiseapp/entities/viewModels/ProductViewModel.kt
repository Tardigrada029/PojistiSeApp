package com.tardigrada.pojistiseapp.entities.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tardigrada.pojistiseapp.entities.AppDatabase
import com.tardigrada.pojistiseapp.entities.Product
import com.tardigrada.pojistiseapp.entities.User
import com.tardigrada.pojistiseapp.entities.repositories.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application): AndroidViewModel(application) {

    // private val readAllProductsData: List<Product>
    private val productRepository: ProductRepository

    init {
        val productDao = AppDatabase.getInstance(application).productDao
        productRepository = ProductRepository(productDao)
        suspend { readAllData() }
        // readAllProductsData = productRepository.readAllProducts()
    }

    fun addProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.addProduct(product)
        }
    }

    fun updateProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            productRepository.updateProduct(product)
        }
    }

    fun readAllData(): LiveData<List<Product>> {
        return productRepository.readAllProducts()
    }
}