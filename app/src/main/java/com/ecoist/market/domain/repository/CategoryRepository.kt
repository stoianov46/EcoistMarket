package com.ecoist.market.domain.repository

import com.ecoist.market.data.mapper.CategoryMapper
import com.ecoist.market.data.model.Category
import com.ecoist.market.data.response.CategoryResponse
import com.ecoist.market.domain.api.ApiService

/**
 * Created by Kirill Stoianov on 18/09/2020.
 */
class CategoryRepository(private val apiService: ApiService) {

    companion object {
        /**
         * Id = 1 it id of top level categories on the site.
         */
        private const val TOP_LEVEL_CATEGORY_PARENT_ID: Int = 1
    }

    /**
     * Get top level [CategoryResponse]'s as on the site.
     *
     * @return list with market main categories.
     */
    suspend fun getTopLevelCategories(): List<Category> {
        return this.getChildCategoriesOf(TOP_LEVEL_CATEGORY_PARENT_ID)
    }

    /**
     * Get list with all existed categories on the site.
     *
     * @return list with all market categories.
     */
    suspend fun getAllCategories(): List<Category> {
        val allCategories = apiService.getAllCategories()
        return CategoryMapper.map(allCategories)
    }

    /**
     * Get list with child categories for destination [parentId].
     *
     * @param parentId - link to parent [CategoryResponse.id].
     * @return list of child categories of parent.
     */
    suspend fun getChildCategoriesOf(parentId: Int): List<Category> {
        val childCategories = apiService.getChildCategories(parentId)
        return CategoryMapper.map(childCategories)
    }
}