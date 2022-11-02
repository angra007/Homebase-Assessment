package com.ankitangra.homebase.presentation.home

import com.ankitangra.homebase.domain.model.Shift

data class HomeState(
    val shifts: List<Shift> = emptyList()
)
