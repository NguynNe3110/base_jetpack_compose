package com.uzuu.base_myproject_jetpackcompose.ui.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.uzuu.base_myproject_jetpackcompose.ui.theme.AppControlSize
import com.uzuu.base_myproject_jetpackcompose.ui.theme.AppThemeTokens

enum class AppButtonStyle { Filled, Tonal, Elevated, Outlined, Text }

@Composable
fun AppButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: AppButtonStyle = AppButtonStyle.Filled,
    size: AppControlSize = AppControlSize.Standard,
    shape: Shape = MaterialTheme.shapes.medium,
    colors: ButtonColors? = null,
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource? = null,
    content: @Composable RowScope.() -> Unit,
) {
    val sizedModifier = modifier.heightIn(min = AppThemeTokens.dimensions.buttonHeight(size))
    when (style) {
        AppButtonStyle.Filled -> Button(
            onClick = onClick, modifier = sizedModifier, enabled = enabled, shape = shape,
            colors = colors ?: ButtonDefaults.buttonColors(),
            elevation = elevation ?: ButtonDefaults.buttonElevation(),
            border = border, contentPadding = contentPadding,
            interactionSource = interactionSource, content = content,
        )
        AppButtonStyle.Tonal -> FilledTonalButton(
            onClick = onClick, modifier = sizedModifier, enabled = enabled, shape = shape,
            colors = colors ?: ButtonDefaults.filledTonalButtonColors(),
            elevation = elevation ?: ButtonDefaults.filledTonalButtonElevation(),
            border = border, contentPadding = contentPadding,
            interactionSource = interactionSource, content = content,
        )
        AppButtonStyle.Elevated -> ElevatedButton(
            onClick = onClick, modifier = sizedModifier, enabled = enabled, shape = shape,
            colors = colors ?: ButtonDefaults.elevatedButtonColors(),
            elevation = elevation ?: ButtonDefaults.elevatedButtonElevation(),
            border = border, contentPadding = contentPadding,
            interactionSource = interactionSource, content = content,
        )
        AppButtonStyle.Outlined -> OutlinedButton(
            onClick = onClick, modifier = sizedModifier, enabled = enabled, shape = shape,
            colors = colors ?: ButtonDefaults.outlinedButtonColors(), elevation = elevation,
            border = border ?: ButtonDefaults.outlinedButtonBorder(enabled),
            contentPadding = contentPadding, interactionSource = interactionSource, content = content,
        )
        AppButtonStyle.Text -> TextButton(
            onClick = onClick, modifier = sizedModifier, enabled = enabled, shape = shape,
            colors = colors ?: ButtonDefaults.textButtonColors(), elevation = elevation,
            border = border, contentPadding = contentPadding,
            interactionSource = interactionSource, content = content,
        )
    }
}

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: AppButtonStyle = AppButtonStyle.Filled,
    size: AppControlSize = AppControlSize.Standard,
    shape: Shape = MaterialTheme.shapes.medium,
    colors: ButtonColors? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
) = AppButton(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    style = style,
    size = size,
    shape = shape,
    colors = colors,
    contentPadding = contentPadding,
) { Text(text) }
