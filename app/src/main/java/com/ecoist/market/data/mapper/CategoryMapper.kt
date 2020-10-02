package com.ecoist.market.data.mapper

import com.ecoist.market.data.model.Category
import com.ecoist.market.data.response.CategoryResponse

/**
 * Created by Kirill Stoianov on 26/09/2020.
 */
object CategoryMapper {

    fun map(categories: List<CategoryResponse>): List<Category> {
        return categories.map { categoryResponse -> mapSingle(categoryResponse) }
    }

    private fun mapSingle(categoryResponse: CategoryResponse): Category {
        return Category(
            id = categoryResponse.id,
            idParent = categoryResponse.idParent,
            name = categoryResponse.name,
            alias = categoryResponse.alias,
            compared = categoryResponse.compared,
            deleted = categoryResponse.deleted,
            showBanner = categoryResponse.showBanner,
            categoryOrder = categoryResponse.categoryOrder,
            product_list_cols = categoryResponse.product_list_cols,
            short_desc_on_product = categoryResponse.short_desc_on_product,
            show_mods = categoryResponse.show_mods,
            isPublic = categoryResponse.isPublic,
            show_links = categoryResponse.show_links
        )
    }
}