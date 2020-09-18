package com.ecoist.market.domain

import com.ecoist.market.data.response.Category

/**
 * Created by Kirill Stoianov on 18/09/2020.
 */
class CategoryRepository(private val apiService: ApiService) {

    suspend fun getAllCategories(): List<Category> {
        return apiService.getAllCategories()
    }

    suspend fun getChildCategoriesOf(parentId: Int): List<Category> {
        return apiService.getChildCategories(parentId)
    }
}