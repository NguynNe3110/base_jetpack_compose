package com.uzuu.base_myproject_jetpackcompose.ui.component.feedback

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppCircularProgress(
    modifier: Modifier = Modifier,
    progress: (() -> Float)? = null,
) = if (progress == null) {
    CircularProgressIndicator(modifier)
} else {
    CircularProgressIndicator(progress = { progress().coerceIn(0f, 1f) }, modifier = modifier)
}

@Composable
fun AppLinearProgress(
    modifier: Modifier = Modifier,
    progress: (() -> Float)? = null,
) = if (progress == null) {
    LinearProgressIndicator(modifier)
} else {
    LinearProgressIndicator(progress = { progress().coerceIn(0f, 1f) }, modifier = modifier)
}
