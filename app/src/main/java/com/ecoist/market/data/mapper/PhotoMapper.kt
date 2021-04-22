package com.ecoist.market.data.mapper

import android.util.Log
import com.ecoist.market.data.model.Photo
import com.ecoist.market.data.response.PhotoResponse
import com.ecoist.market.data.roomdb.PhotoModel

/**
 *Created by Yehor Kudimov on 18.01.2021.
 */
object PhotoMapper {
    fun map(photo: List<PhotoResponse>): List<Photo> {
        return photo
            .map { photoResponse -> mapSingle(photoResponse) }
    }

    fun mapToPhotoModel(photo: List<PhotoResponse>): List<PhotoModel> {
        return photo
            .map { photoModel -> mapSinglePhoto(photoModel) }
    }

    fun mapSingle(photoResponse: PhotoResponse): Photo {
        //val imageUrl: String? = "https://ecoist.com.ua/gallery/"+productResponse.galleryName+"/image_"+productResponse.idImage+"_120_120.jpg"
        //  val imageUrlArray: String? = "https://ecoist.com.ua/gallery/"+productResponse.galleryName+"/image_"+productResponse.idImage+"_120_120.jpg"

        val imageUrl: String? = buildString {
            append("https://ecoist.com.ua/gallery/")
            append(photoResponse.name)
            append("/image_")
            append(photoResponse.id)
            append(".png")
        }

        return Photo(
            name = photoResponse.name,
            id = photoResponse.id,
            gOrder = photoResponse.gOrder,
            width = photoResponse.width,
            height = photoResponse.height,
            imageUrl = imageUrl
        )
    }

    fun mapSinglePhoto(photoResponse: PhotoResponse): PhotoModel {
        //val imageUrl: String? = "https://ecoist.com.ua/gallery/"+productResponse.galleryName+"/image_"+productResponse.idImage+"_120_120.jpg"
        //  val imageUrlArray: String? = "https://ecoist.com.ua/gallery/"+productResponse.galleryName+"/image_"+productResponse.idImage+"_120_120.jpg"

        val imageUrl: String? = buildString {
            append("https://ecoist.com.ua/gallery/")
            append(photoResponse.name)
            append("/image_")
            append(photoResponse.id)
            append(".png")
        }

        return PhotoModel(
            name = photoResponse.name,
            id = photoResponse.id,
            gOrder = photoResponse.gOrder,
            width = photoResponse.width,
            height = photoResponse.height
        )
    }
}
















