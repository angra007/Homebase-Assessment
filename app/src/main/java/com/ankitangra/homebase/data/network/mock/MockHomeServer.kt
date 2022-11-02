package com.ankitangra.homebase.data.network.mock

import androidx.compose.compiler.plugins.kotlin.EmptyFunctionMetrics.name
import com.ankitangra.homebase.data.network.HomeBaseAPI
import com.ankitangra.homebase.data.network.dto.NetworkShift
import com.ankitangra.homebase.data.network.dto.ShiftDto
import com.ankitangra.homebase.domain.model.Shift

class MockHomeServer: HomeBaseAPI {

    private var shiftDto = createShifts()

    private fun createShifts(): ShiftDto {
        val shift1 = NetworkShift(
            role = "Waiter",
            name = "Anna",
            start_date = "2018-04-20 9:00:00 -08:00",
            end_date = "2018-4-20 12:00:00 -08:00",
            color = "red"
        )

        val shift2 = NetworkShift(
            role = "Prep",
            name = "Anton",
            start_date = "2018-04-20 9:00:00 -08:00",
            end_date = "2018-4-20 12:00:00 -08:00",
            color = "blue"
        )

        val shift4 = NetworkShift(
            role = "Prep",
            name = "Anton",
            start_date = "2018-04-20 9:00:00 -08:00",
            end_date = "2018-4-20 12:00:00 -08:00",
            color = "blue"
        )

        val shift5 =  NetworkShift(
            role = "Prep",
            name = "Anton",
            start_date = "2018-04-20 9:00:00 -08:00",
            end_date = "2018-4-20 12:00:00 -08:00",
            color = "blue"
        )

        val shifts = listOf(shift1, shift2, shift4, shift5)

        return ShiftDto(shifts = shifts)
    }

    override fun getShifts(): ShiftDto = shiftDto

    override fun createShift(shift: NetworkShift) {
        val allShifts = shiftDto.shifts.toMutableList()
        allShifts.add(shift)
        shiftDto.shifts = allShifts
    }
}