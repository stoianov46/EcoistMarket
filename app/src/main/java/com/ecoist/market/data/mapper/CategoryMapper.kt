package com.ecoist.market.data.mapper

import com.ecoist.market.data.model.Category
import com.ecoist.market.data.response.CategoryResponse
import com.ecoist.market.data.roomdb.CategoryModel

object CategoryMapper {

    fun map(categories: List<CategoryResponse>): List<Category> {
        return categories
            .filter {
                // Exclude non-active categories
                it.isPublic == 1
            }
            .map { categoryResponse -> mapSingle(categoryResponse) }
    }
    fun mapModel(categories: List<CategoryResponse>): List<CategoryModel> {
        return categories
            .filter {
                // Exclude non-active categories
                it.isPublic == 1
            }
            .map { category -> mapToRoom(category) }
    }

    private fun mapToRoom(categoryResponse: CategoryResponse): CategoryModel {
        return CategoryModel(
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

    private fun mapSingle(categoryResponse: CategoryResponse): Category {

        fun makeUrlForImage(): String {
            var str = "https://ecoist.com.ua/gallery/category/"
            when (categoryResponse.id.toInt()) {
                2 -> return str + "alternativnaja-energia/image_13161_190_190.gif"
                4 -> return str + "energosberezhenie/image_13159_190_190.gif"
                18 -> return str + "electrotransport/image_13157_190_190.gif"
                25 -> return str + "komplektujushie/image_13160_190_190.gif"
                35 -> return str + "ecotovari/image_13162_190_190.gif"
                74 -> return str + "zelenoe-stroitelstvo/image_13158_190_190.gif"
                80 -> return str + "ecoprodukti/image_13163_190_190.gif"
            }
            return str
        }
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
            show_links = categoryResponse.show_links,
            image = makeUrlForImage()
        )
    }


}
