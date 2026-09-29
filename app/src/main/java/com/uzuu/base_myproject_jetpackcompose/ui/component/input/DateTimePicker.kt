package com.uzuu.base_myproject_jetpackcompose.ui.component.input

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDatePickerDialog(
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    dismissButton: (@Composable () -> Unit)? = null,
    shape: Shape = DatePickerDefaults.shape,
    tonalElevation: Dp = DatePickerDefaults.TonalElevation,
    colors: DatePickerColors = DatePickerDefaults.colors(),
    properties: DialogProperties = DialogProperties(usePlatformDefaultWidth = false),
    content: @Composable ColumnScope.() -> Unit,
) = DatePickerDialog(
    onDismissRequest = onDismissRequest,
    confirmButton = confirmButton,
    modifier = modifier,
    dismissButton = dismissButton,
    shape = shape,
    tonalElevation = tonalElevation,
    colors = colors,
    properties = properties,
    content = content,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDatePickerDialog(
    state: DatePickerState,
    onConfirm: (Long?) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    confirmText: String? = null,
    dismissText: String? = null,
    dateFormatter: DatePickerFormatter = DatePickerDefaults.dateFormatter(),
    colors: DatePickerColors = DatePickerDefaults.colors(),
    showModeToggle: Boolean = true,
    focusRequester: FocusRequester? = null,
    properties: DialogProperties = DialogProperties(usePlatformDefaultWidth = false),
) {
    val actualConfirmText = confirmText ?: stringResource(android.R.string.ok)
    val actualDismissText = dismissText ?: stringResource(android.R.string.cancel)
    AppDatePickerDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = { TextButton({ onConfirm(state.selectedDateMillis) }) { Text(actualConfirmText) } },
        dismissButton = { TextButton(onDismissRequest) { Text(actualDismissText) } },
        modifier = modifier,
        colors = colors,
        properties = properties,
    ) {
        DatePicker(
            state = state,
            dateFormatter = dateFormatter,
            colors = colors,
            showModeToggle = showModeToggle,
            focusRequester = focusRequester,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTimePicker(
    state: TimePickerState,
    modifier: Modifier = Modifier,
    colors: TimePickerColors = TimePickerDefaults.colors(),
    layoutType: TimePickerLayoutType = TimePickerDefaults.layoutType(),
) = TimePicker(
    state = state,
    modifier = modifier,
    colors = colors,
    layoutType = layoutType,
)
