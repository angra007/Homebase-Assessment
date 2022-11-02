package com.ankitangra.homebase.domain.usecase

import com.ankitangra.homebase.domain.repository.HomebaseRepository

class CreateShift(
    private val repository: HomebaseRepository
) {

   suspend operator fun invoke() {
       repository.createShift()
   }

}