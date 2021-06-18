package com.ecoist.market.data.roomdb

import androidx.annotation.Keep
import androidx.lifecycle.LiveData
import androidx.room.*


/**
 *Created by Yehor Kudimov on 3/12/2021.
 */
@Dao
interface ProductDao {

    @Query("SELECT * FROM productEco")
    suspend fun getAll(): List<ProductModel>

    @Query("SELECT * FROM productEco")
    fun getLiveDataCategory(): LiveData<List<ProductModel>>

    @Query("SELECT * FROM productEco WHERE id = :id")
    suspend fun findById(id: String): ProductModel?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg productEco: ProductModel)

    @Delete
    fun delete(vararg productEco: ProductModel)

    @Update
    fun update(vararg productEco: ProductModel)

}