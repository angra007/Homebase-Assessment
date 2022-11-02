package com.ankitangra.homebase.core.domain

import androidx.compose.ui.graphics.Color

sealed class Colors {
    companion object {
        fun getValue (string: String): Color {
            return when (string) {
                "red" -> {
                    Color.Red
                }
                "blue" -> {
                    Color.Blue
                }
                "green" -> {
                    Color.Green
                }
                else -> Color.Red
            }
        }
    }
}