package com.ankitangra.homebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ankitangra.homebase.core.navigation.Route
import com.ankitangra.homebase.presentation.detail.DetailScreen
import com.ankitangra.homebase.presentation.home.HomeScreen
import com.ankitangra.homebase.ui.theme.HomebaseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomebaseTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(navController = navController, startDestination = Route.HOME) {

                        composable(Route.HOME) {
                            HomeScreen(onNextClick = {
                                navController.navigate(Route.DETAIL)
                            })
                        }

                        composable(Route.DETAIL) {
                            DetailScreen(onBackPressed = {
                                navController.popBackStack()
                            })
                        }
                    }
                }
            }
        }
    }
}
