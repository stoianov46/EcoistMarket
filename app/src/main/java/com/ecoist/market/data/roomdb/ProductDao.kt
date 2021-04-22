package com.ecoist.market.data.roomdb

import androidx.annotation.Keep
import androidx.lifecycle.LiveData
import androidx.room.*
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *Created by Yehor Kudimov on 3/12/2021.
 */
@Dao
@Keep
interface ProductDao {

    @GET("tss/salemod?a=list_where&col=idCategory")
    suspend fun getProductByIdOfCategoryEco(@Query("idCategory") idCategory: Long): List<ProductModel>

    @GET("tss/salemod?a=list_where&col=idCategory")
    suspend fun getProductByIdOfCategoryLive(@Query("idCategory") idCategory: Long): LiveData<List<ProductModel>>

    @GET("tss/salemod?a=load&col=id")
    suspend fun getProductByIdEco(@Query("id") id: Long): ProductModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg productEco: ProductModel)

    @Delete
    fun delete(vararg productEco: ProductModel)

    @Update
    fun update(vararg productEco: ProductModel)
    /*   @GET("tss/salemod?a=list")
       suspend fun getAllProductsEco(): List<ProductModel>

       @GET("tss/salemod?a=list")
       fun getLiveData(): LiveData<List<ProductModel>>*/
}