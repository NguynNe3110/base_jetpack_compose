package com.uzuu.base_myproject_jetpackcompose.ui.component.display

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.ChipColors
import androidx.compose.material3.ChipElevation
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.SelectableChipElevation
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

enum class AppChipStyle { Assist, ElevatedAssist, Filter, Input, Suggestion }

@Composable
fun AppAssistChip(
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    elevated: Boolean = false,
    shape: Shape = AssistChipDefaults.shape,
    colors: ChipColors = if (elevated) AssistChipDefaults.elevatedAssistChipColors() else AssistChipDefaults.assistChipColors(),
    elevation: ChipElevation? = if (elevated) AssistChipDefaults.elevatedAssistChipElevation() else AssistChipDefaults.assistChipElevation(),
    border: BorderStroke? = if (elevated) null else AssistChipDefaults.assistChipBorder(enabled),
    interactionSource: MutableInteractionSource? = null,
) = if (elevated) {
    ElevatedAssistChip(
        onClick = onClick,
        label = label,
        modifier = modifier,
        enabled = enabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        interactionSource = interactionSource,
    )
} else {
    AssistChip(
        onClick = onClick,
        label = label,
        modifier = modifier,
        enabled = enabled,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        interactionSource = interactionSource,
    )
}

@Composable
fun AppFilterChip(
    selected: Boolean,
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    shape: Shape = FilterChipDefaults.shape,
    colors: SelectableChipColors = FilterChipDefaults.filterChipColors(),
    elevation: SelectableChipElevation? = FilterChipDefaults.filterChipElevation(),
    border: BorderStroke? = FilterChipDefaults.filterChipBorder(enabled, selected),
    interactionSource: MutableInteractionSource? = null,
) = FilterChip(
    selected = selected,
    onClick = onClick,
    label = label,
    modifier = modifier,
    enabled = enabled,
    leadingIcon = leadingIcon,
    trailingIcon = trailingIcon,
    shape = shape,
    colors = colors,
    elevation = elevation,
    border = border,
    interactionSource = interactionSource,
)

@Composable
fun AppInputChip(
    selected: Boolean,
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: (@Composable () -> Unit)? = null,
    avatar: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    shape: Shape = InputChipDefaults.shape,
    colors: SelectableChipColors = InputChipDefaults.inputChipColors(),
    elevation: SelectableChipElevation? = InputChipDefaults.inputChipElevation(),
    border: BorderStroke? = InputChipDefaults.inputChipBorder(enabled, selected),
    interactionSource: MutableInteractionSource? = null,
) = InputChip(
    selected = selected,
    onClick = onClick,
    label = label,
    modifier = modifier,
    enabled = enabled,
    leadingIcon = leadingIcon,
    avatar = avatar,
    trailingIcon = trailingIcon,
    shape = shape,
    colors = colors,
    elevation = elevation,
    border = border,
    interactionSource = interactionSource,
)

@Composable
fun AppSuggestionChip(
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: (@Composable () -> Unit)? = null,
    shape: Shape = SuggestionChipDefaults.shape,
    colors: ChipColors = SuggestionChipDefaults.suggestionChipColors(),
    elevation: ChipElevation? = SuggestionChipDefaults.suggestionChipElevation(),
    border: BorderStroke? = SuggestionChipDefaults.suggestionChipBorder(enabled),
    interactionSource: MutableInteractionSource? = null,
) = SuggestionChip(
    onClick = onClick,
    label = label,
    modifier = modifier,
    enabled = enabled,
    icon = icon,
    shape = shape,
    colors = colors,
    elevation = elevation,
    border = border,
    interactionSource = interactionSource,
)

@Composable
fun AppChip(
    onClick: () -> Unit,
    label: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    style: AppChipStyle = AppChipStyle.Assist,
    selected: Boolean = false,
    enabled: Boolean = true,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
) = when (style) {
    AppChipStyle.Assist -> AssistChip(onClick, label, modifier, enabled, leadingIcon, trailingIcon)
    AppChipStyle.ElevatedAssist -> ElevatedAssistChip(onClick, label, modifier, enabled, leadingIcon, trailingIcon)
    AppChipStyle.Filter -> FilterChip(selected, onClick, label, modifier, enabled, leadingIcon, trailingIcon)
    AppChipStyle.Input -> InputChip(selected, onClick, label, modifier, enabled, leadingIcon, trailingIcon)
    AppChipStyle.Suggestion -> SuggestionChip(onClick, label, modifier, enabled, leadingIcon)
}

@Composable
fun AppBadgedBox(
    badge: @Composable BoxScope.() -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) = BadgedBox(badge, modifier, content)

@Composable
fun AppBadge(
    modifier: Modifier = Modifier,
    containerColor: Color = androidx.compose.material3.BadgeDefaults.containerColor,
    contentColor: Color = androidx.compose.material3.contentColorFor(containerColor),
    content: (@Composable RowScope.() -> Unit)? = null,
) = Badge(modifier = modifier, containerColor = containerColor, contentColor = contentColor, content = content)
