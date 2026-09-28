package com.uzuu.base_myproject_jetpackcompose.ui.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
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

enum class AppButtonStyle { Filled, Tonal, Elevated, Outlined, Text }

@Composable
fun AppButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: AppButtonStyle = AppButtonStyle.Filled,
    shape: Shape = MaterialTheme.shapes.medium,
    colors: ButtonColors? = null,
    elevation: ButtonElevation? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    when (style) {
        AppButtonStyle.Filled -> Button(
            onClick = onClick, modifier = modifier, enabled = enabled, shape = shape,
            colors = colors ?: ButtonDefaults.buttonColors(),
            elevation = elevation ?: ButtonDefaults.buttonElevation(),
            contentPadding = contentPadding, content = content,
        )
        AppButtonStyle.Tonal -> FilledTonalButton(
            onClick = onClick, modifier = modifier, enabled = enabled, shape = shape,
            colors = colors ?: ButtonDefaults.filledTonalButtonColors(),
            elevation = elevation ?: ButtonDefaults.filledTonalButtonElevation(),
            contentPadding = contentPadding, content = content,
        )
        AppButtonStyle.Elevated -> ElevatedButton(
            onClick = onClick, modifier = modifier, enabled = enabled, shape = shape,
            colors = colors ?: ButtonDefaults.elevatedButtonColors(),
            elevation = elevation ?: ButtonDefaults.elevatedButtonElevation(),
            contentPadding = contentPadding, content = content,
        )
        AppButtonStyle.Outlined -> OutlinedButton(
            onClick = onClick, modifier = modifier, enabled = enabled, shape = shape,
            colors = colors ?: ButtonDefaults.outlinedButtonColors(), elevation = elevation,
            contentPadding = contentPadding, content = content,
        )
        AppButtonStyle.Text -> TextButton(
            onClick = onClick, modifier = modifier, enabled = enabled, shape = shape,
            colors = colors ?: ButtonDefaults.textButtonColors(), elevation = elevation,
            contentPadding = contentPadding, content = content,
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
) = AppButton(onClick, modifier, enabled, style) { Text(text) }
