package com.example.myamberone.data.repoimpl

import com.example.myamberone.core.Loading
import com.example.myamberone.core.Resource
import com.example.myamberone.core.Success
import com.example.myamberone.data.service.ApiService
import com.example.myamberone.domain.model.MainResponseItem
import com.example.myamberone.domain.repo.JeweleryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class JeweleryRepositoryImpl @Inject constructor(private val api: ApiService) : JeweleryRepository {

    override fun getJewelery(): Flow<Resource<List<MainResponseItem>>> = flow {
        try {
            emit(Loading())
            val result = api.getJewelery()
            emit(Success(result.hits.map { it.toDomain() }))
        } catch (e: IOException) {
            emit(com.example.myamberone.core.Error(msg = "$e"))
        } catch (e: HttpException) {
            emit(com.example.myamberone.core.Error(msg = "$e"))
        }
    }
}