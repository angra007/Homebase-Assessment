package com.ankitangra.homebase.domain.model

import com.ankitangra.homebase.core.domain.Colors

data class Shift(
    val role: String,
    val name: String,
    val startDate: String,
    val endDate: String,
    val color: String
)



