package com.tardigrada.pojistiseapp.entities.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tardigrada.pojistiseapp.entities.AppDatabase
import com.tardigrada.pojistiseapp.entities.Insurance
// import com.tardigrada.pojistiseapp.entities.relations.ProductWithInsurances
// import com.tardigrada.pojistiseapp.entities.relations.UserWithInsurances
import com.tardigrada.pojistiseapp.entities.repositories.InsuranceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InsuranceViewModel(application: Application): AndroidViewModel(application) {

    // private val readAllInsurancesData: List<Insurance>
    private val insuranceRepository: InsuranceRepository

    init {
        val insuranceDao = AppDatabase.getInstance(application).insuranceDao
        insuranceRepository = InsuranceRepository(insuranceDao)
        suspend { readAllData() }
        // readAllInsurancesData = insuranceRepository.readAllInsurances()
    }

    suspend fun addInsurance(insurance: Insurance) {
        viewModelScope.launch(Dispatchers.IO) {
            insuranceRepository.addInsurance(insurance)
        }
    }

    suspend fun readAllData(): LiveData<List<Insurance>> {
        return insuranceRepository.readAllInsurances()
    }

    /*
    suspend fun readAllProductWithInsurancesData(productId: Int): LiveData<List<ProductWithInsurances>> {
        return insuranceRepository.readAllInsurancesForProduct(productId)
    }

    suspend fun readAllUserWithInsurancesData(userId: Int): LiveData<List<UserWithInsurances>> {
        return insuranceRepository.readAllInsurancesForUser(userId)
    }

     */
}