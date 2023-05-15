package com.example.myamberone.data.service

import com.example.myamberone.data.dto.MainProduct
import com.example.myamberone.data.dto.MainProductItem
import retrofit2.http.GET

interface ApiService {
    @GET("/")
    fun getJewelery(): MainProduct<MainProductItem>
}