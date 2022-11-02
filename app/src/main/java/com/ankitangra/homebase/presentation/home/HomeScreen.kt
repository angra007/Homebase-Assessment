package com.ankitangra.homebase.presentation.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen (
    onNextClick: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {

    LazyColumn() {
        items(viewModel.state.shifts) {
            Text(text = it.name)
        }
    }
}