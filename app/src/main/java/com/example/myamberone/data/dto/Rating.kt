package com.example.myamberone.data.dto

import com.example.myamberone.data.maper.DataMaper

data class Rating(
    val count: Int,
    val rate: Double
) : DataMaper<Rating> {
    override fun toDomain() = Rating(
        count = count,
        rate = rate
    )
}