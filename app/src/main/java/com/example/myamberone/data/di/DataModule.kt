package com.example.myamberone.data.di

import com.example.myamberone.data.repoimpl.JeweleryRepositoryImpl
import com.example.myamberone.domain.repo.JeweleryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindJeweleryRepository(jeweleryRepositoryImpl: JeweleryRepositoryImpl): JeweleryRepository
}