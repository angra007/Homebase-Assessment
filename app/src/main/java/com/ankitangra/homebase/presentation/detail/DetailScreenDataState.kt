package com.ankitangra.homebase.presentation.detail

data class DetailScreenDataState(
    val startDate : String = "",
    val endDate : String = "",
    val selectedEmployee: String = "Anna",
    val selectedRole: String = "Waitress",
    val selectedColor: String = "Red"
)
