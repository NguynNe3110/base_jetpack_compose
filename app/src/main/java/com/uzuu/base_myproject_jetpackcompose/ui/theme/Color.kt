package com.uzuu.base_myproject_jetpackcompose.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

internal val AppLightColors = lightColorScheme(
    primary = Color(0xFF006E2C), onPrimary = Color.White,
    primaryContainer = Color(0xFF8BFA9E), onPrimaryContainer = Color(0xFF002108),
    secondary = Color(0xFF526350), onSecondary = Color.White,
    secondaryContainer = Color(0xFFD5E8D0), onSecondaryContainer = Color(0xFF101F10),
    tertiary = Color(0xFF39656B), onTertiary = Color.White,
    tertiaryContainer = Color(0xFFBDEBF1), onTertiaryContainer = Color(0xFF001F23),
    error = Color(0xFFBA1A1A), onError = Color.White,
    errorContainer = Color(0xFFFFDAD6), onErrorContainer = Color(0xFF410002),
    background = Color(0xFFFCFDF7), onBackground = Color(0xFF1A1C19),
    surface = Color(0xFFFCFDF7), onSurface = Color(0xFF1A1C19),
    surfaceVariant = Color(0xFFDEE5DA), onSurfaceVariant = Color(0xFF424940),
    outline = Color(0xFF727970), outlineVariant = Color(0xFFC2C9BE),
)

internal val AppDarkColors = darkColorScheme(
    primary = Color(0xFF6DDD84), onPrimary = Color(0xFF003913),
    primaryContainer = Color(0xFF00531F), onPrimaryContainer = Color(0xFF8BFA9E),
    secondary = Color(0xFFB9CCB5), onSecondary = Color(0xFF253424),
    secondaryContainer = Color(0xFF3B4B39), onSecondaryContainer = Color(0xFFD5E8D0),
    tertiary = Color(0xFFA1CED5), onTertiary = Color(0xFF00363C),
    tertiaryContainer = Color(0xFF1F4D53), onTertiaryContainer = Color(0xFFBDEBF1),
    error = Color(0xFFFFB4AB), onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A), onErrorContainer = Color(0xFFFFDAD6),
    background = Color(0xFF1A1C19), onBackground = Color(0xFFE2E3DD),
    surface = Color(0xFF1A1C19), onSurface = Color(0xFFE2E3DD),
    surfaceVariant = Color(0xFF424940), onSurfaceVariant = Color(0xFFC2C9BE),
    outline = Color(0xFF8C9389), outlineVariant = Color(0xFF424940),
)
