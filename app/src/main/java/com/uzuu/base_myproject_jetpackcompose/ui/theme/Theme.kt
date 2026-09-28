package com.uzuu.base_myproject_jetpackcompose.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext

object AppThemeTokens {
    val colors @Composable @ReadOnlyComposable get() = MaterialTheme.colorScheme
    val typography @Composable @ReadOnlyComposable get() = MaterialTheme.typography
    val shapes @Composable @ReadOnlyComposable get() = MaterialTheme.shapes
    val spacing @Composable @ReadOnlyComposable get() = LocalAppSpacing.current
    val dimensions @Composable @ReadOnlyComposable get() = LocalAppComponentDimensions.current
}

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    spacing: AppSpacing = AppSpacing(),
    dimensions: AppComponentDimensions = AppComponentDimensions(),
    content: @Composable () -> Unit,
) {
    val colors = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> AppDarkColors
        else -> AppLightColors
    }
    CompositionLocalProvider(
        LocalAppSpacing provides spacing,
        LocalAppComponentDimensions provides dimensions,
    ) {
        MaterialTheme(
            colorScheme = colors,
            typography = AppTypography,
            shapes = AppShapes,
            content = content,
        )
    }
}

@Deprecated("Use AppTheme", ReplaceWith("AppTheme(darkTheme, dynamicColor, content = content)"))
@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) = AppTheme(darkTheme, dynamicColor, content = content)
