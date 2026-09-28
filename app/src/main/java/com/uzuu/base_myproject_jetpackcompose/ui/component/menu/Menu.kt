package com.uzuu.base_myproject_jetpackcompose.ui.component.menu

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.PopupProperties

@Composable
fun AppDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    items: List<String>,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    enabled: (Int) -> Boolean = { true },
    leadingIcon: (@Composable (Int) -> Unit)? = null,
) = DropdownMenu(expanded, onDismissRequest, modifier) {
    items.forEachIndexed { index, item ->
        DropdownMenuItem(
            text = { Text(item) },
            onClick = { onItemClick(index) },
            leadingIcon = leadingIcon?.let { { it(index) } },
            enabled = enabled(index),
        )
    }
}
