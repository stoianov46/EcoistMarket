package com.ecoist.market.data.roomdb

import com.ecoist.market.data.mapper.ProductMapper
import com.ecoist.market.data.model.Product
import com.ecoist.market.domain.api.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *Created by Yehor Kudimov on 3/12/2021.
 */
class ProductRepositoryEco (private val apiService: ApiService) {
    val io: CoroutineDispatcher
        get() = Dispatchers.IO

            //  private val dao = EcoDataBase.instance!!.getProductDao()


    suspend fun getProductById(id: Long): ProductModel {
        val productResponse = apiService.getProductById(id)
        return ProductMapper.mapSingleModel(productResponse)
    }

    suspend fun getProductsByIdOfCategory(id: Long): List<ProductModel> {
        val products = apiService.getProductByIdOfCategory(id)
        return ProductMapper.mapRoom(products)
    }

}