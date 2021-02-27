package com.ecoist.market.domain.api

import androidx.annotation.Keep
import com.ecoist.market.data.response.CategoryResponse
import com.ecoist.market.data.response.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Kirill Stoianov on 18/09/2020.
 */
@Keep
interface ApiService {

    @GET("tss/category?a=list")
    suspend fun getAllCategories(): List<CategoryResponse>

    @GET("tss/category?a=list_where&col=idParent")
    suspend fun getChildCategories(@Query("idParent") idParent: Long): List<CategoryResponse>

    @GET("tss/salemod?a=list")
    suspend fun getAllProducts(): List<ProductResponse>

    @GET("tss/salemod?a=list_where&col=idCategory")
    suspend fun getProductByIdOfCategory(@Query("idCategory") idCategory: Long): List<ProductResponse>

    @GET("tss/salemod?a=load&col=id")
    suspend fun getProductById(@Query("id") id: Long): ProductResponse
}