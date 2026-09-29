package com.uzuu.base_myproject_jetpackcompose.ui.component.feedback

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppCircularProgress(
    modifier: Modifier = Modifier,
    progress: (() -> Float)? = null,
    color: Color = ProgressIndicatorDefaults.circularColor,
    strokeWidth: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,
    trackColor: Color = if (progress == null) ProgressIndicatorDefaults.circularIndeterminateTrackColor else ProgressIndicatorDefaults.circularDeterminateTrackColor,
    strokeCap: StrokeCap = if (progress == null) ProgressIndicatorDefaults.CircularIndeterminateStrokeCap else ProgressIndicatorDefaults.CircularDeterminateStrokeCap,
    gapSize: Dp = ProgressIndicatorDefaults.CircularIndicatorTrackGapSize,
) = if (progress == null) {
    CircularProgressIndicator(modifier, color, strokeWidth, trackColor, strokeCap, gapSize)
} else {
    CircularProgressIndicator({ progress().coerceIn(0f, 1f) }, modifier, color, strokeWidth, trackColor, strokeCap, gapSize)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppLinearProgress(
    modifier: Modifier = Modifier,
    progress: (() -> Float)? = null,
    color: Color = ProgressIndicatorDefaults.linearColor,
    trackColor: Color = ProgressIndicatorDefaults.linearTrackColor,
    strokeCap: StrokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
    gapSize: Dp = ProgressIndicatorDefaults.LinearIndicatorTrackGapSize,
) = if (progress == null) {
    LinearProgressIndicator(modifier, color, trackColor, strokeCap, gapSize)
} else {
    LinearProgressIndicator(progress = { progress().coerceIn(0f, 1f) }, modifier = modifier, color = color, trackColor = trackColor, strokeCap = strokeCap, gapSize = gapSize)
}
