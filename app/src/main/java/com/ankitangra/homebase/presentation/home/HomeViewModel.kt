package com.ankitangra.homebase.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ankitangra.homebase.domain.usecase.GetShift
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getShift: GetShift
): ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    fun getInitialData() {
        viewModelScope.launch {
            val shifts = getShift()
            state = state.copy (
                shifts = shifts
            )
        }
    }

}