package com.uzuu.base_myproject_jetpackcompose.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val AppShapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(16.dp),
    extraLarge = RoundedCornerShape(28.dp),
)

@Immutable
data class AppSpacing(
    val none: Dp = 0.dp,
    val xxs: Dp = 2.dp,
    val xs: Dp = 4.dp,
    val sm: Dp = 8.dp,
    val md: Dp = 16.dp,
    val lg: Dp = 24.dp,
    val xl: Dp = 32.dp,
    val xxl: Dp = 48.dp,
)

enum class AppControlSize { Compact, Standard, Large }

@Immutable
data class AppComponentDimensions(
    val minimumTouchTarget: Dp = 48.dp,
    val compactTextFieldHeight: Dp = 48.dp,
    val textFieldHeight: Dp = 56.dp,
    val compactButtonHeight: Dp = 40.dp,
    val buttonHeight: Dp = 48.dp,
    val largeButtonHeight: Dp = 56.dp,
    val segmentedButtonHeight: Dp = 40.dp,
) {
    init {
        require(minimumTouchTarget >= 48.dp) { "Touch targets must be at least 48.dp" }
        require(compactTextFieldHeight >= minimumTouchTarget) {
            "Compact text fields must preserve the minimum touch target"
        }
        require(textFieldHeight >= compactTextFieldHeight) {
            "Standard text fields cannot be smaller than compact text fields"
        }
        require(compactButtonHeight >= 40.dp) { "Compact buttons must be at least 40.dp" }
        require(buttonHeight >= compactButtonHeight) { "Standard buttons cannot be smaller than compact buttons" }
        require(largeButtonHeight >= buttonHeight) { "Large buttons cannot be smaller than standard buttons" }
        require(segmentedButtonHeight >= 40.dp) { "Segmented buttons must be at least 40.dp" }
    }

    fun buttonHeight(size: AppControlSize): Dp = when (size) {
        AppControlSize.Compact -> compactButtonHeight
        AppControlSize.Standard -> buttonHeight
        AppControlSize.Large -> largeButtonHeight
    }
}

internal val LocalAppSpacing = staticCompositionLocalOf { AppSpacing() }
internal val LocalAppComponentDimensions = staticCompositionLocalOf { AppComponentDimensions() }
