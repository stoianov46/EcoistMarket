package com.ecoist.market.domain.repository

import com.ecoist.market.data.mapper.PhotoMapper
import com.ecoist.market.data.mapper.ProductMapper
import com.ecoist.market.data.model.Photo
import com.ecoist.market.data.model.Product
import com.ecoist.market.data.response.PhotoResponse
import com.ecoist.market.domain.api.ApiService

class ProductRepository(private val apiService: ApiService) {

    suspend fun getAllProducts(): List<Product> {
        val products = apiService.getAllProducts()
        return ProductMapper.map(products)
    }

    suspend fun getProductById(id: Long): Product {
        val productResponse = apiService.getProductById(id)
        return ProductMapper.mapSingle(productResponse)
    }

    suspend fun getProductsByIdOfCategory(id: Long): List<Product> {
        val products = apiService.getProductByIdOfCategory(id)
        return ProductMapper.map(products)
    }

    suspend fun getPhotoList(name: String?): List<Photo> {
        val photos = apiService.getPhotoList(name)
        return PhotoMapper.map(photos)
    }

}