package com.uzuu.base_myproject_jetpackcompose.ui.component.button

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.Alignment
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uzuu.base_myproject_jetpackcompose.ui.theme.AppThemeTokens

@Composable
fun AppSegmentedButtonRow(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) = Row(modifier = modifier, content = content)

@Composable
fun RowScope.AppSegmentedButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.small,
    selectedContainerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
    unselectedContainerColor: Color = MaterialTheme.colorScheme.surface,
    selectedContentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
    unselectedContentColor: Color = MaterialTheme.colorScheme.onSurface,
    border: BorderStroke? = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
    tonalElevation: Dp = 0.dp,
    shadowElevation: Dp = 0.dp,
    contentPadding: PaddingValues = PaddingValues(
        horizontal = AppThemeTokens.spacing.md,
        vertical = AppThemeTokens.spacing.sm,
    ),
    weight: Float? = 1f,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit,
) {
    require(weight == null || weight > 0f) { "weight must be positive or null" }
    val itemModifier = if (weight == null) modifier else modifier.weight(weight)
    Surface(
        selected = selected,
        onClick = onClick,
        modifier = itemModifier,
        enabled = enabled,
        shape = shape,
        color = if (selected) selectedContainerColor else unselectedContainerColor,
        contentColor = if (selected) selectedContentColor else unselectedContentColor,
        border = border,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
        interactionSource = interactionSource,
    ) {
        Row(
            modifier = Modifier
                .defaultMinSize(minHeight = AppThemeTokens.dimensions.segmentedButtonHeight)
                .padding(contentPadding),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            content = content,
        )
    }
}

