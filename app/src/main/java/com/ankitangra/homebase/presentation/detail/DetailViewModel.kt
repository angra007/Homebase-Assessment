package com.ankitangra.homebase.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankitangra.homebase.domain.usecase.CreateShift
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class DetailViewModel @Inject constructor(
    val createShift: CreateShift
): ViewModel() {

    companion object {
        private const val DATE_FORMAT = "yyyy-MM-dd"
    }

    var state by mutableStateOf(DetailScreenDataState())
        private set

    fun handleEvent(event: DetailScreenEvents) {
        when (event) {
            is DetailScreenEvents.DidEnterStartDate -> {
                val dateFormatted = SimpleDateFormat(DATE_FORMAT, Locale.US).format(event.startDate)
                state = state.copy(
                    startDate = dateFormatted
                )
            }

            is DetailScreenEvents.DidEnterEndDate -> {
                val dateFormatted = SimpleDateFormat(DATE_FORMAT, Locale.US).format(event.endDate)
                state = state.copy(
                    endDate = dateFormatted
                )
            }

            is DetailScreenEvents.DidSelectEmployee -> {
                state = state.copy(
                    selectedEmployee = event.employeeName
                )
            }

            is DetailScreenEvents.DidSelectRole -> {
                state = state.copy(
                    selectedRole = event.role
                )
            }

            is DetailScreenEvents.DidSelectColor -> {
                state = state.copy(
                    selectedColor = event.color
                )
            }

            is DetailScreenEvents.DidSave -> {
                viewModelScope.launch {
                    createShift(
                        state.startDate,
                        state.endDate,
                        state.selectedEmployee,
                        state.selectedRole,
                        state.selectedColor
                    )
                }
            }
        }
    }
}