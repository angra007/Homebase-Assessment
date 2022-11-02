package com.ankitangra.homebase.domain.repository

import com.ankitangra.homebase.domain.model.Shift

interface HomebaseRepository {
    suspend fun getShifts(): List<Shift>
    suspend fun createShift(shift: Shift)
}