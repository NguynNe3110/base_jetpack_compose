package com.uzuu.base_myproject_jetpackcompose.ui.component.input

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import kotlin.ranges.ClosedFloatingPointRange

@Composable
fun AppSlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
    colors: SliderColors = SliderDefaults.colors(),
    interactionSource: MutableInteractionSource? = null,
) {
    require(valueRange.start < valueRange.endInclusive) { "valueRange must have a positive length" }
    require(steps >= 0) { "steps cannot be negative" }
    Slider(
        value = value.coerceIn(valueRange),
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        steps = steps,
        onValueChangeFinished = onValueChangeFinished,
        colors = colors,
        interactionSource = interactionSource ?: remember { MutableInteractionSource() },
    )
}

/** Advanced Material 3 API for custom thumb and track content. */
@ExperimentalMaterial3Api
@Composable
fun AppSliderWithSlots(
    value: Float,
    onValueChange: (Float) -> Unit,
    thumb: @Composable (SliderState) -> Unit,
    track: @Composable (SliderState) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
    colors: SliderColors = SliderDefaults.colors(),
    interactionSource: MutableInteractionSource? = null,
) {
    require(valueRange.start < valueRange.endInclusive) { "valueRange must have a positive length" }
    require(steps >= 0) { "steps cannot be negative" }
    Slider(
        value = value.coerceIn(valueRange),
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        onValueChangeFinished = onValueChangeFinished,
        colors = colors,
        interactionSource = interactionSource ?: remember { MutableInteractionSource() },
        steps = steps,
        thumb = thumb,
        track = track,
        valueRange = valueRange,
    )
}

@Composable
fun AppRangeSlider(
    value: ClosedFloatingPointRange<Float>,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
    colors: SliderColors = SliderDefaults.colors(),
) {
    require(valueRange.start < valueRange.endInclusive) { "valueRange must have a positive length" }
    require(steps >= 0) { "steps cannot be negative" }
    val safeStart = value.start.coerceIn(valueRange)
    val safeEnd = value.endInclusive.coerceIn(valueRange).coerceAtLeast(safeStart)
    RangeSlider(
        value = safeStart..safeEnd,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        steps = steps,
        onValueChangeFinished = onValueChangeFinished,
        colors = colors,
    )
}

/** Advanced Material 3 API for custom thumbs and track content. */
@ExperimentalMaterial3Api
@Composable
fun AppRangeSliderWithSlots(
    value: ClosedFloatingPointRange<Float>,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
    startThumb: @Composable (RangeSliderState) -> Unit,
    endThumb: @Composable (RangeSliderState) -> Unit,
    track: @Composable (RangeSliderState) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
    colors: SliderColors = SliderDefaults.colors(),
    startInteractionSource: MutableInteractionSource? = null,
    endInteractionSource: MutableInteractionSource? = null,
) {
    require(valueRange.start < valueRange.endInclusive) { "valueRange must have a positive length" }
    require(steps >= 0) { "steps cannot be negative" }
    val safeStart = value.start.coerceIn(valueRange)
    val safeEnd = value.endInclusive.coerceIn(valueRange).coerceAtLeast(safeStart)
    RangeSlider(
        value = safeStart..safeEnd,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        onValueChangeFinished = onValueChangeFinished,
        colors = colors,
        startInteractionSource = startInteractionSource ?: remember { MutableInteractionSource() },
        endInteractionSource = endInteractionSource ?: remember { MutableInteractionSource() },
        startThumb = startThumb,
        endThumb = endThumb,
        track = track,
        steps = steps,
    )
}
