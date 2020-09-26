package com.ecoist.market.domain.repository

import com.ecoist.market.data.response.Category
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
     * Get top level [Category]'s as on the site.
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
        return apiService.getAllCategories()
    }

    /**
     * Get list with child categories for destination [parentId].
     *
     * @param parentId - link to parent [Category.id].
     * @return list of child categories of parent.
     */
    suspend fun getChildCategoriesOf(parentId: Int): List<Category> {
        return apiService.getChildCategories(parentId)
    }
}