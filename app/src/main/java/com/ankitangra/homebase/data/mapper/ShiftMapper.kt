package com.ankitangra.homebase.data.mapper

import com.ankitangra.homebase.core.domain.Colors
import com.ankitangra.homebase.data.network.dto.NetworkShift
import com.ankitangra.homebase.domain.model.Shift

fun NetworkShift.toShift(): Shift {
    return Shift(
        role = this.role,
        name = this.name,
        startDate = this.start_date,
        endDate = this.end_date,
        color = this.color
    )
}
fun Shift.toNetworkShift(): NetworkShift {
    return NetworkShift(
        role = this.role,
        name = this.name,
        start_date = this.startDate,
        end_date = this.endDate,
        color = this.color
    )
}