package com.ecoist.market.data.roomdb


import androidx.lifecycle.LiveData
import androidx.room.*


/**
 *Created by Yehor Kudimov on 3/12/2021.
 */
@Dao

interface CategoryDao {

    @Query("SELECT * FROM category")
    suspend fun getAll(): List<CategoryModel>

    @Query("SELECT * FROM category")
    fun getLiveDataCategory(): LiveData<List<CategoryModel>>

    @Query("SELECT * FROM category WHERE id = :id")
    suspend fun findById(id: String): CategoryModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg category: CategoryModel)

    @Delete
    fun delete(vararg category: CategoryModel)

    @Update
    fun update(vararg category: CategoryModel)
}
