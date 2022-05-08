package com.tardigrada.pojistiseapp.entities.repositories

import androidx.lifecycle.LiveData
import com.tardigrada.pojistiseapp.entities.Insurance
import com.tardigrada.pojistiseapp.entities.dao.InsuranceDao
// import com.tardigrada.pojistiseapp.entities.relations.ProductWithInsurances
// import com.tardigrada.pojistiseapp.entities.relations.UserWithInsurances

class InsuranceRepository(private val insuranceDao: InsuranceDao) {

    fun  readAllInsurances(): LiveData<List<Insurance>> {
        return insuranceDao.getAllInsurances()
    }

    /*
    fun readAllInsurancesForUser(userId: Int): LiveData<List<UserWithInsurances>> {
        return insuranceDao.getUserWithInsurances(userId)
    }

    fun readAllInsurancesForProduct(productId: Int): LiveData<List<ProductWithInsurances>> {
        return insuranceDao.getProductWithInsurances(productId)
    }

     */

    suspend fun addInsurance(insurance: Insurance) {
        insuranceDao.insertInsurance(insurance)
    }

    suspend fun updateInsurance(insurance: Insurance) {
        insuranceDao.updateInsurance(insurance)
    }

    suspend fun deleteInsurance(insurance: Insurance) {
        insuranceDao.deleteInsurance(insurance)
    }
}