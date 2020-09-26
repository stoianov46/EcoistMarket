package com.ecoist.market.domain

import androidx.annotation.Keep
import com.ecoist.market.data.response.Category
import com.ecoist.market.data.response.Product
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Kirill Stoianov on 18/09/2020.
 */
@Keep
interface ApiService {

    @GET("tss/category?a=list")
    suspend fun getAllCategories(): List<Category>

    @GET("tss/category?a=list_where&col=idParent")
    suspend fun getChildCategories(@Query("idParent") idParent: Int): List<Category>

    @GET("tss/salemod?a=list")
    suspend fun getAllProducts(): List<Product>

    @GET("tss/salemod?a=list_where&col=idCategory")
    suspend fun getProductByIdOfCategory(@Query("idCategory") idCategory: Int): List<Product>


    @GET("tss/salemod?a=list_where&col=id")
    suspend fun getProductById(@Query("id") id: Int): Product
}