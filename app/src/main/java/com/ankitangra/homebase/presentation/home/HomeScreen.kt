package com.ankitangra.homebase.presentation.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen (
    viewModel: HomeViewModel = hiltViewModel()
) {
    Text(text = viewModel.message)
}