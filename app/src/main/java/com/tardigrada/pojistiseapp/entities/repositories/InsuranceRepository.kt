package com.tardigrada.pojistiseapp.entities.repositories

import com.tardigrada.pojistiseapp.entities.Insurance
import com.tardigrada.pojistiseapp.entities.dao.InsuranceDao
import com.tardigrada.pojistiseapp.entities.relations.ProductWithInsurances
import com.tardigrada.pojistiseapp.entities.relations.UserWithInsurances

class InsuranceRepository(private val insuranceDao: InsuranceDao) {

    suspend fun  readAllInsurances(): List<Insurance> {
        return insuranceDao.getAllInsurances()
    }

    suspend fun readAllInsurancesForUser(userId: Int): List<UserWithInsurances> {
        return insuranceDao.getUserWithInsurances(userId)
    }

    suspend fun readAllInsurancesForProduct(productId: Int): List<ProductWithInsurances> {
        return insuranceDao.getProductWithInsurances(productId)
    }

    suspend fun addInsurance(insurance: Insurance) {
        insuranceDao.insertInsurance(insurance)
    }
}