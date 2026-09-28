package com.uzuu.base_myproject_jetpackcompose.ui.component.display

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.FilterChip
import androidx.compose.material3.InputChip
import androidx.compose.material3.SuggestionChip
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class AppChipStyle { Assist, ElevatedAssist, Filter, Input, Suggestion }

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
fun AppBadge(modifier: Modifier = Modifier, content: (@Composable RowScope.() -> Unit)? = null) =
    Badge(modifier = modifier, content = content)
