package com.ankitangra.homebase.data.repository

import com.ankitangra.homebase.data.mapper.toShift
import com.ankitangra.homebase.data.network.mock.MockHomeServer
import com.ankitangra.homebase.domain.model.Shift
import com.ankitangra.homebase.domain.repository.HomebaseRepository

class HomeBaseRepositoryImpl(
    private val server: MockHomeServer
): HomebaseRepository {

    override suspend fun getShifts(): List<Shift> {
        val shifts = server.getShifts()
        return shifts.shifts.map { it.toShift() }
    }

    override suspend fun createShift() {
        TODO("Not yet implemented")
    }

}