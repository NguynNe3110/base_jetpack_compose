package com.uzuu.base_myproject_jetpackcompose.ui.component.display

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

enum class AppCardStyle { Filled, Elevated, Outlined }

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    style: AppCardStyle = AppCardStyle.Filled,
    shape: Shape = MaterialTheme.shapes.medium,
    colors: CardColors = when (style) {
        AppCardStyle.Filled -> CardDefaults.cardColors()
        AppCardStyle.Elevated -> CardDefaults.elevatedCardColors()
        AppCardStyle.Outlined -> CardDefaults.outlinedCardColors()
    },
    elevation: CardElevation = when (style) {
        AppCardStyle.Filled -> CardDefaults.cardElevation()
        AppCardStyle.Elevated -> CardDefaults.elevatedCardElevation()
        AppCardStyle.Outlined -> CardDefaults.outlinedCardElevation()
    },
    border: BorderStroke? = when (style) {
        AppCardStyle.Outlined -> CardDefaults.outlinedCardBorder(enabled)
        else -> null
    },
    interactionSource: MutableInteractionSource? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    when (style) {
        AppCardStyle.Filled -> if (onClick == null) {
            Card(modifier = modifier, shape = shape, colors = colors, elevation = elevation, border = border, content = content)
        } else {
            Card(onClick = onClick, modifier = modifier, enabled = enabled, shape = shape, colors = colors, elevation = elevation, border = border, interactionSource = interactionSource, content = content)
        }
        AppCardStyle.Elevated -> if (onClick == null) {
            ElevatedCard(modifier = modifier, shape = shape, colors = colors, elevation = elevation, content = content)
        } else {
            ElevatedCard(onClick = onClick, modifier = modifier, enabled = enabled, shape = shape, colors = colors, elevation = elevation, interactionSource = interactionSource, content = content)
        }
        AppCardStyle.Outlined -> if (onClick == null) {
            OutlinedCard(modifier = modifier, shape = shape, colors = colors, elevation = elevation, border = border ?: CardDefaults.outlinedCardBorder(), content = content)
        } else {
            OutlinedCard(onClick = onClick, modifier = modifier, enabled = enabled, shape = shape, colors = colors, elevation = elevation, border = border ?: CardDefaults.outlinedCardBorder(enabled), interactionSource = interactionSource, content = content)
        }
    }
}
