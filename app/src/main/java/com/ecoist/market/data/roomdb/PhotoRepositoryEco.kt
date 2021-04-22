package com.ecoist.market.data.roomdb

import com.ecoist.market.domain.api.ApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 *Created by Yehor Kudimov on 3/12/2021.
 */
class PhotoRepositoryEco (    private val apiService: ApiService){
    val io: CoroutineDispatcher
        get() = Dispatchers.IO

    private val dao = EcoDataBase.instance!!.getPhotoDao()
//


}