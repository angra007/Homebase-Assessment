package com.ankitangra.homebase.presentation.home

import androidx.compose.compiler.plugins.kotlin.EmptyFunctionMetrics.name
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ankitangra.homebase.core.components.AppBar
import com.ankitangra.homebase.core.domain.Colors
import com.ankitangra.homebase.ui.theme.Shapes

@Composable
fun HomeScreen (
    onNextClick: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(
            horizontal = 32.dp,
            vertical = 16.dp
        )
    )   {

        AppBar(
            title = "Coffee Co Shifts",
            titleColor = Color.Black,
            rightBarButtonText = "Add Shift",
        ) {
            onNextClick.invoke()
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(
                        30.dp
                    )
                )
                .clip(
                    RoundedCornerShape(
                        30.dp
                    )
                )
                .padding(16.dp)
        ) {
            items(viewModel.state.shifts) {
                HomeScreenItem(
                    name = it.name,
                    role = it.role,
                    date = "Fri 21",
                    day = "12",
                    color = it.color
                )
            }
        }
    }
}

@Composable
fun HomeScreenItem(
    name: String,
    role: String,
    date: String,
    day: String,
    color: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Row(
            modifier = Modifier
                .width(150.dp)
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = name)
            Text(text = "($role)")
            Text(text = date)
        }

        Row(
            modifier = Modifier
                .wrapContentWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Canvas(modifier = Modifier.size(64.dp), onDraw = {
                drawCircle(color = Colors.getValue(color))
            })

            Spacer(modifier = Modifier.width(2.dp))

            Text(text = day)
        }
    }
}


