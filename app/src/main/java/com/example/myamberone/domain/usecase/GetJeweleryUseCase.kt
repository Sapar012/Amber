package com.example.myamberone.domain.usecase

import com.example.myamberone.domain.repo.JeweleryRepository
import javax.inject.Inject

class GetJeweleryUseCase  @Inject constructor(private val repository: JeweleryRepository) {
   operator fun invoke() = repository.getJewelery()
}