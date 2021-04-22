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
interface CategoryDao {
    @GET()
    suspend fun getEcoCategories(@Query("idParent") idParent: Long): List<CategoryModel>

    @GET()
    suspend fun getCategoriesLive(@Query("idParent") idParent: Long): LiveData<List<CategoryModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg category: CategoryModel)

    @Delete
    fun delete(vararg category: CategoryModel)

    @Update
    fun update(vararg category: CategoryModel)
}
