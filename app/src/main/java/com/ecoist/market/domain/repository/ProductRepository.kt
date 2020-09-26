package com.ecoist.market.domain.repository

import com.ecoist.market.data.mapper.ProductMapper
import com.ecoist.market.data.model.Product
import com.ecoist.market.domain.api.ApiService

/**
 * Created by Kirill Stoianov on 18/09/2020.
 */
class ProductRepository(private val apiService: ApiService) {

    suspend fun getAllProducts(): List<Product> {
        val products = apiService.getAllProducts()
        return ProductMapper.map(products)
    }

    suspend fun getProductById(id: Int): Product {
        val productResponse = apiService.getProductById(id)
        return ProductMapper.mapSingle(productResponse)
    }

    suspend fun getProductByIdOfCategory(id: Int): List<Product> {
        val products = apiService.getProductByIdOfCategory(id)
        return ProductMapper.map(products)
    }
}