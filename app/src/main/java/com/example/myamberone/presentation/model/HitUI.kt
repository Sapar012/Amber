package com.example.myamberone.presentation.model

import com.example.myamberone.data.dto.Rating
import com.example.myamberone.domain.model.MainResponseItem

data class HitUI(
    val id: Int,
    val descriptionProduct: String,
    val imageProduct: String,
    val price: Double,
    val titleProduct: String,
    val rating:Rating
)
fun MainResponseItem.toUI() = HitUI(
    id = id,
    descriptionProduct = descriptionProduct,
    imageProduct = imageProduct,
    price = price,
    titleProduct = titleProduct,
    rating = rating.toDomain()
)