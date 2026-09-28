package com.uzuu.base_myproject_jetpackcompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val AppFontFamily = FontFamily.Default

val AppTypography = Typography(
    displayLarge = appTextStyle(FontWeight.Normal, 57, 64, -0.25),
    displayMedium = appTextStyle(FontWeight.Normal, 45, 52),
    displaySmall = appTextStyle(FontWeight.Normal, 36, 44),
    headlineLarge = appTextStyle(FontWeight.SemiBold, 32, 40),
    headlineMedium = appTextStyle(FontWeight.SemiBold, 28, 36),
    headlineSmall = appTextStyle(FontWeight.SemiBold, 24, 32),
    titleLarge = appTextStyle(FontWeight.SemiBold, 22, 28),
    titleMedium = appTextStyle(FontWeight.SemiBold, 16, 24, 0.15),
    titleSmall = appTextStyle(FontWeight.SemiBold, 14, 20, 0.1),
    bodyLarge = appTextStyle(FontWeight.Normal, 16, 24, 0.5),
    bodyMedium = appTextStyle(FontWeight.Normal, 14, 20, 0.25),
    bodySmall = appTextStyle(FontWeight.Normal, 12, 16, 0.4),
    labelLarge = appTextStyle(FontWeight.SemiBold, 14, 20, 0.1),
    labelMedium = appTextStyle(FontWeight.SemiBold, 12, 16, 0.5),
    labelSmall = appTextStyle(FontWeight.SemiBold, 11, 16, 0.5),
)

private fun appTextStyle(weight: FontWeight, size: Int, lineHeight: Int, spacing: Double = 0.0) =
    TextStyle(
        fontFamily = AppFontFamily,
        fontWeight = weight,
        fontSize = size.sp,
        lineHeight = lineHeight.sp,
        letterSpacing = spacing.toFloat().sp,
    )
