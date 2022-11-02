package com.ankitangra.homebase.domain.usecase

import com.ankitangra.homebase.domain.model.Shift
import com.ankitangra.homebase.domain.repository.HomebaseRepository

class GetShift(
    private val repository: HomebaseRepository
) {
    suspend operator fun invoke(): List<Shift> {
        return repository.getShifts()
    }
}