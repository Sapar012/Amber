package com.example.myamberone.domain.model

import com.example.myamberone.data.dto.Rating

data class MainResponseItem(
    val id: Int,
    val descriptionProduct: String,
    val imageProduct: String,
    val price: Double,
    val titleProduct: String,
    val rating:Rating
)