package com.ecoist.market.domain.repository

import com.ecoist.market.data.response.Product
import com.ecoist.market.domain.api.ApiService

/**
 * Created by Kirill Stoianov on 18/09/2020.
 */
class ProductRepository(private val apiService: ApiService) {

    suspend fun getAllProducts(): List<Product> {
        return apiService.getAllProducts()
    }

    suspend fun getProductById(id: Int): Product {
        return apiService.getProductById(id)
    }
    suspend fun getProductByIdOfCategory(id: Int): List<Product> {
        return apiService.getProductByIdOfCategory(id)
    }
}