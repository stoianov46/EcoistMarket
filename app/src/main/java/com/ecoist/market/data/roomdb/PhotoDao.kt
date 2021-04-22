package com.ecoist.market.data.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *Created by Yehor Kudimov on 3/12/2021.
 */
@Dao
interface PhotoDao {


    @GET("tss/gallery?a=list_where&col=name")
    suspend fun getPhotoListEco(@Query("name") name: String?): List<PhotoModel>

    @GET("tss/gallery?a=list_where&col=name")
    suspend fun getLiveData(@Query("name") name: String?): LiveData<List<PhotoModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg photo: PhotoModel)

    @Delete
    fun delete(vararg photo: PhotoModel)

    @Update
    fun update(vararg photo: PhotoModel)
}