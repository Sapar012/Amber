package com.example.myamberone.data.dto

import com.example.myamberone.data.maper.DataMaper
import com.example.myamberone.domain.model.MainResponseItem

data class MainProductItem(
    val id: Int,
    val descriptionProduct: String,
    val imageProduct: String,
    val price: Double,
    val titleProduct: String,
    val rating:Rating
):DataMaper<MainResponseItem> {
    override fun toDomain() = MainResponseItem (
        id = id,
        descriptionProduct = descriptionProduct,
        imageProduct = imageProduct,
        price = price,
        titleProduct = titleProduct,
        rating = rating.toDomain()
    )
}