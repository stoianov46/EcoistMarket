package com.ecoist.market.data.roomdb


import androidx.lifecycle.LiveData
import androidx.room.*


/**
 *Created by Yehor Kudimov on 3/12/2021.
 */
@Dao
interface CategoryDao {

    @Query("SELECT * FROM category WHERE idParent= :id")
    fun getLiveDataCategory(id: Long): LiveData<List<CategoryModel>>

    @Query("SELECT * FROM category WHERE idParent = :id")
    suspend fun findByIdParent(id: Long): List<CategoryModel>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg category: CategoryModel)

}
