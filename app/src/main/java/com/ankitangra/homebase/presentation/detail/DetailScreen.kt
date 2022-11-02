package com.ankitangra.homebase.presentation.detail

import android.provider.Settings.System.DATE_FORMAT
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ankitangra.homebase.core.components.AppBar
import com.ankitangra.homebase.core.components.ExpandableTextView
import com.swift.intentsender.utility.SelectableTextField
import com.swift.intentsender.utility.showTimePicker

@Composable
fun DetailScreen (
    onBackPressed: () -> Unit,
    viewModel: DetailViewModel = hiltViewModel()
) {

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
    val state = viewModel.state


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
                viewModel.handleEvent(
                    DetailScreenEvents.DidSave
                )
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
                
                SelectableTextField (
                    value = TextFieldValue (state.startDate),
                    modifier = Modifier.width(200.dp),
                    onValueChange = { },
                    label = { }
                ) {
                    showTimePicker(
                        context,
                        1991,
                        1,
                        11,
                    ) {
                        viewModel.handleEvent(
                            DetailScreenEvents.DidEnterStartDate(it)
                        )
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
                    value = TextFieldValue (state.endDate),
                    modifier = Modifier.width(200.dp),
                    onValueChange = {  },
                    label = { }
                ) {
                    showTimePicker(
                        context,
                        1991,
                        1,
                        11,
                    ) {
                        viewModel.handleEvent(
                            DetailScreenEvents.DidEnterEndDate(it)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            ExpandableTextView(
                textValue = state.selectedEmployee,
                label = "Select an employee",
                items = listOf("Anna", "Anton", "Eugene", "Keyvon"),
                modifier = Modifier.width(300.dp),
                expanded = employeeSelected.value,
                onItemSelected = {
                    viewModel.handleEvent(
                        DetailScreenEvents.DidSelectEmployee( it )
                    )
                    employeeSelected.value = !employeeSelected.value
                },
                toggleState = {
                    employeeSelected.value = !employeeSelected.value
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ExpandableTextView(
                textValue = state.selectedRole,
                label = "Select a role",
                items = listOf("Waitress", "Prep", "Cook", "Clean"),
                modifier = Modifier.width(300.dp),
                expanded = roleSelected.value,
                onItemSelected = {
                    viewModel.handleEvent(
                        DetailScreenEvents.DidSelectRole( it )
                    )
                    roleSelected.value = !roleSelected.value
                },
                toggleState = {
                    roleSelected.value = !roleSelected.value
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            ExpandableTextView(
                textValue = state.selectedColor,
                label = "Select a color",
                items = listOf("Red", "Green", "Blue"),
                modifier = Modifier.width(300.dp),
                expanded = colorSelected.value,
                onItemSelected = {
                    viewModel.handleEvent(
                        DetailScreenEvents.DidSelectRole( it )
                    )
                    colorSelected.value = !colorSelected.value
                },
                toggleState = {
                    colorSelected.value = !colorSelected.value
                }
            )

        }
    }
}