package com.ankitangra.homebase.presentation.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailScreen (
    viewModel: DetailViewModel = hiltViewModel()
) {

    Text(text = "Here")
}