package com.ankitangra.homebase.data.network

import com.ankitangra.homebase.data.network.dto.NetworkShift
import com.ankitangra.homebase.data.network.dto.ShiftDto

interface HomeBaseAPI {
    fun getShifts(): ShiftDto

    fun createShift(shift: NetworkShift)
}