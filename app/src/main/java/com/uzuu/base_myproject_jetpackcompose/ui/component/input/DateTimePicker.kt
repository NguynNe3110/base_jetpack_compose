package com.uzuu.base_myproject_jetpackcompose.ui.component.input

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDatePickerDialog(
    state: DatePickerState,
    onConfirm: (Long?) -> Unit,
    onDismissRequest: () -> Unit,
    confirmText: String = "OK",
    dismissText: String = "Cancel",
) = DatePickerDialog(
    onDismissRequest = onDismissRequest,
    confirmButton = { TextButton({ onConfirm(state.selectedDateMillis) }) { Text(confirmText) } },
    dismissButton = { TextButton(onDismissRequest) { Text(dismissText) } },
) { DatePicker(state = state) }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTimePicker(state: TimePickerState) = TimePicker(state = state)
