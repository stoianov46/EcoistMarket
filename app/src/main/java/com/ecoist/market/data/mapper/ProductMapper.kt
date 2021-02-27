package com.ecoist.market.data.mapper

import com.ecoist.market.data.model.Product
import com.ecoist.market.data.response.ProductResponse

/**
 * Created by Kirill Stoianov on 26/09/2020.
 */
object ProductMapper {

    fun map(products: List<ProductResponse>): List<Product> {
        return products
            .filter {
                // Exclude non-active products
                it.isPublic == 1
            }
            .map { productResponse -> mapSingle(productResponse) }
    }

    fun mapSingle(productResponse: ProductResponse): Product {

        //val imageUrl: String? = "https://ecoist.com.ua/gallery/"+productResponse.galleryName+"/image_"+productResponse.idImage+"_120_120.jpg"
        val imageUrl: String? = buildString{
            append( "https://ecoist.com.ua/gallery/")
            append(productResponse.galleryName)
            append("/image_")
            append( productResponse.idImage)
            append("_120_120.jpg")
        }

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