package com.uzuu.base_myproject_jetpackcompose.ui.component.menu

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.MenuDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties

@Composable
fun AppDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    offset: DpOffset = DpOffset.Zero,
    scrollState: ScrollState = rememberScrollState(),
    properties: PopupProperties = PopupProperties(focusable = true),
    shape: Shape = MenuDefaults.shape,
    containerColor: Color = MenuDefaults.containerColor,
    tonalElevation: Dp = MenuDefaults.TonalElevation,
    shadowElevation: Dp = MenuDefaults.ShadowElevation,
    border: BorderStroke? = null,
    content: @Composable ColumnScope.() -> Unit,
) = DropdownMenu(
    expanded = expanded,
    onDismissRequest = onDismissRequest,
    modifier = modifier,
    offset = offset,
    scrollState = scrollState,
    properties = properties,
    shape = shape,
    containerColor = containerColor,
    tonalElevation = tonalElevation,
    shadowElevation = shadowElevation,
    border = border,
    content = content,
)

@Composable
fun AppDropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    items: List<String>,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    enabled: (Int) -> Boolean = { true },
    leadingIcon: (@Composable (Int) -> Unit)? = null,
    trailingIcon: (@Composable (Int) -> Unit)? = null,
) = AppDropdownMenu(expanded, onDismissRequest, modifier) {
    items.forEachIndexed { index, item ->
        DropdownMenuItem(
            text = { Text(item) },
            onClick = { onItemClick(index) },
            leadingIcon = leadingIcon?.let { { it(index) } },
            trailingIcon = trailingIcon?.let { { it(index) } },
            enabled = enabled(index),
        )
    }
}
