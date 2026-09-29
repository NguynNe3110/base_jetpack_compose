package com.uzuu.base_myproject_jetpackcompose.ui.component.display

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun AppListItem(
    headlineContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    supportingContent: (@Composable () -> Unit)? = null,
    overlineContent: (@Composable () -> Unit)? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    colors: ListItemColors = ListItemDefaults.colors(),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
) = ListItem(
    headlineContent = headlineContent,
    modifier = modifier,
    overlineContent = overlineContent,
    supportingContent = supportingContent,
    leadingContent = leadingContent,
    trailingContent = trailingContent,
    colors = colors,
    tonalElevation = tonalElevation,
    shadowElevation = shadowElevation,
)

@Composable
fun AppListItem(
    headline: String,
    modifier: Modifier = Modifier,
    supportingText: String? = null,
    overlineText: String? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    colors: ListItemColors = ListItemDefaults.colors(),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
) = AppListItem(
    headlineContent = { Text(headline) },
    modifier = modifier,
    overlineContent = overlineText?.let { { Text(it) } },
    supportingContent = supportingText?.let { { Text(it) } },
    leadingContent = leadingContent,
    trailingContent = trailingContent,
    colors = colors,
    tonalElevation = tonalElevation,
    shadowElevation = shadowElevation,
)

@Composable
fun AppDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = androidx.compose.material3.DividerDefaults.color,
) = HorizontalDivider(modifier, thickness, color)

@Composable
fun AppVerticalDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = androidx.compose.material3.DividerDefaults.color,
) = VerticalDivider(modifier, thickness, color)
