package com.ecoist.market.data.roomdb

import androidx.lifecycle.LiveData
import com.ecoist.market.data.mapper.CategoryMapper
import com.ecoist.market.data.response.CategoryResponse
import com.ecoist.market.domain.api.ApiService
import kotlinx.coroutines.*

/**
 *Created by Yehor Kudimov on 3/12/2021.
 */
class CategoryRepositoryEco(
    private val apiService: ApiService
) : NetworkBoundResource<CategoryModel, CategoryResponse>() {

    companion object {
        private const val TOP_LEVEL_CATEGORY_PARENT_ID: Long = 1
    }

    val dao = EcoDataBase.instance!!.getCategoryDao()

    fun getLiveDateById(id: Long): LiveData<List<CategoryModel>> {
        return dao.getLiveDataCategory(id)
    }

    suspend fun getTopLevelCategoriesRoom() {
        dao.insert(* this.getChildCategoriesOfRoom(TOP_LEVEL_CATEGORY_PARENT_ID).toTypedArray())
    }

    suspend fun initCommon(idParent: Long) {
        dao.insert(* this.getChildCategoriesOfRoom(idParent).toTypedArray())
    }

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



