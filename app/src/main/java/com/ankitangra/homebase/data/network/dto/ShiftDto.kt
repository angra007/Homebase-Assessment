package com.ankitangra.homebase.data.network.dto


data class ShiftDto (
    val shifts: List<NetworkShift>
)

data class NetworkShift (
    val role: String,
    val name: String,
    val start_date: String,
    val end_date: String,
    val color: String
)