package com.ankitangra.homebase.presentation.detail

import java.util.Date

sealed class DetailScreenEvents {
    data class DidEnterStartDate(val startDate: Date): DetailScreenEvents()
    data class DidEnterEndDate(val endDate: Date): DetailScreenEvents()
    data class DidSelectEmployee(val employeeName: String): DetailScreenEvents()
    data class DidSelectRole(val role: String): DetailScreenEvents()
    data class DidSelectColor(val color: String): DetailScreenEvents()
    object DidSave: DetailScreenEvents()
}
