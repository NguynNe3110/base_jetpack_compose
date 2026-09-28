package com.uzuu.base_myproject_jetpackcompose.ui.component.feedback

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppAlertDialog(
    title: String,
    text: String,
    confirmText: String,
    onConfirm: () -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    dismissText: String? = null,
    onDismiss: () -> Unit = onDismissRequest,
    icon: (@Composable () -> Unit)? = null,
) = AlertDialog(
    onDismissRequest = onDismissRequest,
    confirmButton = { TextButton(onConfirm) { Text(confirmText) } },
    modifier = modifier,
    dismissButton = dismissText?.let { { TextButton(onDismiss) { Text(it) } } },
    icon = icon,
    title = { Text(title) },
    text = { Text(text) },
)
