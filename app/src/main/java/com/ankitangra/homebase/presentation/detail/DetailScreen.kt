package com.ankitangra.homebase.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ankitangra.homebase.core.components.AppBar
import com.ankitangra.homebase.core.components.ExpandableTextView
import com.swift.intentsender.utility.SelectableTextField
import com.swift.intentsender.utility.showTimePicker
import java.text.SimpleDateFormat
import java.util.Locale

private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

@Composable
fun DetailScreen (
    onBackPressed: () -> Unit,
    viewModel: DetailViewModel = hiltViewModel()
) {

    val startDate = remember {
        mutableStateOf(TextFieldValue())
    }

    val endDate = remember {
        mutableStateOf(TextFieldValue())
    }

    val employeeSelected = remember {
        mutableStateOf(false)
    }

    val roleSelected = remember {
        mutableStateOf(false)
    }

    val colorSelected = remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(
            horizontal = 32.dp,
            vertical = 16.dp
        )
    ) {

        AppBar(
            title = "Coffee Co Shifts",
            titleColor = Color.Black,
            leftBarButtonText = "Back",
            leftBarButtonClicked = {
                onBackPressed()
            },
            rightBarButtonText = "Save",
            rightButtonClicked = {

            }
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .width(300.dp)
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "Start Date", modifier = Modifier.align(Alignment.CenterVertically))
                
                Spacer(modifier = Modifier.width(8.dp))
                
                SelectableTextField(
                    value = startDate.value,
                    modifier = Modifier.width(200.dp),
                    onValueChange = { startDate.value = it },
                    label = { Text(text = "Select a day") }) {
                    showTimePicker(
                        context,
                        1991,
                        1,
                        11,
                    ) {
                        val dateFormatted = SimpleDateFormat(DATE_FORMAT, Locale.US).format(it)
                        startDate.value = TextFieldValue(dateFormatted)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .width(300.dp)
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "End Date",
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(8.dp))

                SelectableTextField(
                    value = endDate.value,
                    modifier = Modifier.width(200.dp),
                    onValueChange = { endDate.value = it },
                    label = { Text(text = "Select a day") }
                ) {
                    showTimePicker(
                        context,
                        1991,
                        1,
                        11,
                    ) {
                        val dateFormatted = SimpleDateFormat(DATE_FORMAT, Locale.US).format(it)
                        endDate.value = TextFieldValue(dateFormatted)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            ExpandableTextView(
                textValue = "Anna",
                label = "Select an employee",
                items = listOf("Anna", "Anton", "Eugene", "Keyvon"),
                modifier = Modifier.width(300.dp),
                expanded = employeeSelected.value,
                onItemSelected = {
                    employeeSelected.value = !employeeSelected.value
                },
                toggleState = {
                    employeeSelected.value = !employeeSelected.value
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ExpandableTextView(
                textValue = "Waitress",
                label = "Select a role",
                items = listOf("Waitress", "Prep", "Cook", "Clean"),
                modifier = Modifier.width(300.dp),
                expanded = roleSelected.value,
                onItemSelected = {
                    roleSelected.value = !roleSelected.value
                },
                toggleState = {
                    roleSelected.value = !roleSelected.value
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ExpandableTextView(
                textValue = "Red",
                label = "Select a color",
                items = listOf("Red", "Green", "Blue"),
                modifier = Modifier.width(300.dp),
                expanded = colorSelected.value,
                onItemSelected = {
                    colorSelected.value = !colorSelected.value
                },
                toggleState = {
                    colorSelected.value = !colorSelected.value
                }
            )

        }
    }
}