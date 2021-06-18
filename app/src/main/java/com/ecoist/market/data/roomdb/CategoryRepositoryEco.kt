package com.ecoist.market.data.roomdb

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ecoist.market.data.mapper.CategoryMapper
import com.ecoist.market.data.response.CategoryResponse
import com.ecoist.market.domain.api.ApiService
import com.ecoist.market.domain.repository.CategoryRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*

/**
 *Created by Yehor Kudimov on 3/12/2021.
 */

class CategoryRepositoryEco(
    private val apiService: ApiService
) : NetworkBoundResource<CategoryModel, CategoryResponse>() {

    val dao = EcoDataBase.instance!!.getCategoryDao()
    val livedate = dao.getLiveDataCategory()

    companion object {
        private const val TOP_LEVEL_CATEGORY_PARENT_ID: Long = 1

    }

    suspend fun coffee() = dao.insert(*getTopLevelCategoriesRoom().toTypedArray())


    suspend fun getTopLevelCategoriesRoom(): List<CategoryModel> {
        return this.getChildCategoriesOfRoom(TOP_LEVEL_CATEGORY_PARENT_ID)
    }

    //first
    suspend fun getChildCategoriesOfRoom(parentId: Long): List<CategoryModel> {
        val childCategories = apiService.getChildCategories(parentId)
        return CategoryMapper.mapModel(childCategories)
    }

    override fun processResponse(response: CategoryResponse): CategoryModel {
        TODO("Not yet implemented")
    }

    override suspend fun saveCallResults(items: CategoryModel) {

    }

    override fun shouldFetch(data: CategoryModel?): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun loadFromDb(): CategoryModel {
        TODO("Not yet implemented")
    }

    override fun createCallAsync(): Deferred<CategoryResponse> {
        TODO("Not yet implemented")
    }

    val io: CoroutineDispatcher
        get() = Dispatchers.IO

}



