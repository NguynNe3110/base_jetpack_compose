package com.uzuu.base_myproject_jetpackcompose.ui.component.button

import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class AppIconButtonStyle { Standard, Filled, Tonal, Outlined }

@Composable
fun AppIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: AppIconButtonStyle = AppIconButtonStyle.Standard,
    colors: IconButtonColors? = null,
    interactionSource: androidx.compose.foundation.interaction.MutableInteractionSource? = null,
    content: @Composable () -> Unit,
) = when (style) {
    AppIconButtonStyle.Standard -> IconButton(onClick = onClick, modifier = modifier.minimumInteractiveComponentSize(), enabled = enabled, colors = colors ?: IconButtonDefaults.iconButtonColors(), interactionSource = interactionSource, content = content)
    AppIconButtonStyle.Filled -> FilledIconButton(onClick = onClick, modifier = modifier.minimumInteractiveComponentSize(), enabled = enabled, colors = colors ?: IconButtonDefaults.filledIconButtonColors(), interactionSource = interactionSource, content = content)
    AppIconButtonStyle.Tonal -> FilledTonalIconButton(onClick = onClick, modifier = modifier.minimumInteractiveComponentSize(), enabled = enabled, colors = colors ?: IconButtonDefaults.filledTonalIconButtonColors(), interactionSource = interactionSource, content = content)
    AppIconButtonStyle.Outlined -> OutlinedIconButton(onClick = onClick, modifier = modifier.minimumInteractiveComponentSize(), enabled = enabled, colors = colors ?: IconButtonDefaults.outlinedIconButtonColors(), interactionSource = interactionSource, content = content)
}

@Composable
fun AppIconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: AppIconButtonStyle = AppIconButtonStyle.Standard,
    colors: IconToggleButtonColors? = null,
    interactionSource: androidx.compose.foundation.interaction.MutableInteractionSource? = null,
    content: @Composable () -> Unit,
) = when (style) {
    AppIconButtonStyle.Standard -> IconToggleButton(checked = checked, onCheckedChange = onCheckedChange, modifier = modifier.minimumInteractiveComponentSize(), enabled = enabled, colors = colors ?: IconButtonDefaults.iconToggleButtonColors(), interactionSource = interactionSource, content = content)
    AppIconButtonStyle.Filled -> FilledIconToggleButton(checked = checked, onCheckedChange = onCheckedChange, modifier = modifier.minimumInteractiveComponentSize(), enabled = enabled, colors = colors ?: IconButtonDefaults.filledIconToggleButtonColors(), interactionSource = interactionSource, content = content)
    AppIconButtonStyle.Tonal -> FilledTonalIconToggleButton(checked = checked, onCheckedChange = onCheckedChange, modifier = modifier.minimumInteractiveComponentSize(), enabled = enabled, colors = colors ?: IconButtonDefaults.filledTonalIconToggleButtonColors(), interactionSource = interactionSource, content = content)
    AppIconButtonStyle.Outlined -> OutlinedIconToggleButton(checked = checked, onCheckedChange = onCheckedChange, modifier = modifier.minimumInteractiveComponentSize(), enabled = enabled, colors = colors ?: IconButtonDefaults.outlinedIconToggleButtonColors(), interactionSource = interactionSource, content = content)
}

