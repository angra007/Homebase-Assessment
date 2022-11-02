package com.ankitangra.homebase.domain.usecase

import com.ankitangra.homebase.domain.model.Shift
import com.ankitangra.homebase.domain.repository.HomebaseRepository

class CreateShift(
    private val repository: HomebaseRepository
) {

   suspend operator fun invoke(
       role: String,
       name: String,
       startDate: String,
       endDate: String,
       color: String
   ) {
       val shift = Shift(
           role,
           name,
           startDate,
           endDate,
           color
       )
       repository.createShift(shift)
   }

}