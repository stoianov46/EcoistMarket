package com.ecoist.market.data.roomdb

import androidx.annotation.Keep
import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow


/**
 *Created by Yehor Kudimov on 3/12/2021.
 */
@Dao
interface ProductDao {

    @Query("SELECT * FROM productEco WHERE idCategory = :id")
    fun findByIdFlowx(id: Long): Flow<List<ProductModel>>

    @Query("SELECT * FROM productEco WHERE id = :id")
    fun findByIdFlowxOne(id: Long): Flow<ProductModel>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg productEco: ProductModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOne( productEco: ProductModel)

    @Delete
    fun delete(vararg productEco: ProductModel)

    @Update
    fun update(vararg productEco: ProductModel)

}