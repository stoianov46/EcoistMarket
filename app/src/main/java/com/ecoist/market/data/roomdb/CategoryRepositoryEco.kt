package com.ecoist.market.data.roomdb

import com.ecoist.market.data.mapper.CategoryMapper
import com.ecoist.market.data.response.CategoryResponse
import com.ecoist.market.domain.api.ApiService
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow

/**
 *Created by Yehor Kudimov on 3/12/2021.
 */
class CategoryRepositoryEco(
    private val apiService: ApiService
) : NetworkBoundResource<List<CategoryModel>, List<CategoryResponse>>() {
    companion object {
        private const val TOP_LEVEL_CATEGORY_PARENT_ID: Long = 1
    }
    val dao = EcoDataBase.instance!!.getCategoryDao()


    suspend fun getChildCategoriesOfRoom(parentId: Long): List<CategoryModel> {
        val childCategories = apiService.getChildCategories(parentId)
        return CategoryMapper.mapModel(childCategories)
    }

    fun getItems(parentId: Long): Flow<Resource<List<CategoryModel>>> {
        return networkBoundResourceMay(
            query = { dao.getCategoryFlowX(parentId) },
            fetch = {
                delay(2000)
                apiService.getChildCategories(parentId)
            },
            saveFetchResult = { item ->
                CategoryMapper.mapModel(item).also { dao.insert(*it.toTypedArray()) }
            }
        )
    }

    val io: CoroutineDispatcher
        get() = Dispatchers.IO

    override fun processResponse(response: List<CategoryResponse>): List<CategoryModel> {
        return CategoryMapper.mapModel(response)
    }

    override suspend fun saveCallResults(items: List<CategoryModel>) {
        dao.delete()
        dao.insert(*items.toTypedArray())
    }

    override fun shouldFetch(data: List<CategoryModel>?): Boolean {
        return true
       // CategoryMapper.mapModel(item).also { dao.insert(*it.toTypedArray()) }
    }

    override suspend fun loadFromDb(): List<CategoryModel> {
        return dao.getCategory()
    }

    override fun createCallAsync(): Deferred<List<CategoryResponse>> {
        return apiService.getAllCategoriesDeffAsync()
    }

}



