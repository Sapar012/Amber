package com.example.myamberone.domain.repo

import com.example.myamberone.core.Resource
import com.example.myamberone.domain.model.MainResponseItem
import kotlinx.coroutines.flow.Flow

interface JeweleryRepository {
    fun getJewelery(): Flow<Resource<List<MainResponseItem>>>
}