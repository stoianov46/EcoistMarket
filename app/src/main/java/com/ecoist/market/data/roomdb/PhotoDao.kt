package com.ecoist.market.data.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*


/**
 *Created by Yehor Kudimov on 3/12/2021.
 */
@Dao
interface PhotoDao {

    @Query("SELECT * FROM photo")
    suspend fun getAll(): List<PhotoModel>

    @Query("SELECT * FROM photo")
    fun getLiveDataCategory(): LiveData<List<PhotoModel>>

    @Query("SELECT * FROM photo WHERE id = :id")
    suspend fun findById(id: String): PhotoModel?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg photo: PhotoModel)

    @Delete
    fun delete(vararg photo: PhotoModel)

    @Update
    fun update(vararg photo: PhotoModel)
}