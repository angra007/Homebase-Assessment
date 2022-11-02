package com.swift.intentsender.utility

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.runtime.Composable
import java.util.Calendar
import java.util.Date


fun showTimePicker (
    context: Context,
    initYear: Int,
    initMonth: Int,
    initDay: Int,
    onDateSelected: (Date) -> Unit
) {
    val timePickerDialog = DatePickerDialog(
        context, { _, year: Int, month: Int, day: Int ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, day)
            val date = calendar.time
            onDateSelected.invoke(date)
        },
        initYear,
        initMonth,
        initDay
    )
    timePickerDialog.show()
}