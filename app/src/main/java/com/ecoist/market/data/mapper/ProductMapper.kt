package com.ecoist.market.data.mapper

import com.ecoist.market.data.model.Product
import com.ecoist.market.data.response.ProductResponse

/**
 * Created by Kirill Stoianov on 26/09/2020.
 */
object ProductMapper {

    fun map(products: List<ProductResponse>): List<Product> {
        return products.map { productResponse -> mapSingle(productResponse) }
    }

    fun mapSingle(productResponse: ProductResponse): Product {

        /*
        * TODO: example https://ecoist.com.ua/gallery/solnechnoe-zarjadnoe-kvazar-kv-10-pm/image_12306_120_120.jpg
        * */
        val imageUrl: String? = null  // TODO("Implement image url")

        return Product(
            mpn = productResponse.mpn,
            galleryName = productResponse.galleryName,
            rating = productResponse.rating,
            descriptionFull = productResponse.descriptionFull,
            discount = productResponse.discount,
            garanty = productResponse.garanty,
            idBrand = productResponse.idBrand,
            name = productResponse.name,
            baseId = productResponse.baseId,
            odiscount = productResponse.odiscount,
            mark = productResponse.mark,
            idCategory = productResponse.idCategory,
            id = productResponse.id,
            priceAutogen = productResponse.priceAutogen,
            coment = productResponse.coment,
            price = productResponse.price,
            alias = productResponse.alias,
            isPublic = productResponse.isPublic,
            idImage = productResponse.idImage,
            deleted = productResponse.deleted,
            description = productResponse.description,
            imageUrl = imageUrl
        )
    }
}