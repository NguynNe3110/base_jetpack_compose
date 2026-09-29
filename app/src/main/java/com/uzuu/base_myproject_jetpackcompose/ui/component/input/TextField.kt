package com.uzuu.base_myproject_jetpackcompose.ui.component.input

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import com.uzuu.base_myproject_jetpackcompose.ui.theme.AppThemeTokens

enum class AppTextFieldStyle { Filled, Outlined }
enum class AppTextFieldSize { Compact, Standard }

/**
 * Text input controlled by the app design system.
 *
 * Use [size] instead of forcing a fixed `Modifier.height`. Compact is 48dp—the minimum safe touch
 * target—and uses reduced content padding. The field grows for multiple lines or supporting text,
 * so text is never clipped by this component's own constraints.
 */
@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    supportingText: String? = null,
    labelContent: (@Composable () -> Unit)? = null,
    placeholderContent: (@Composable () -> Unit)? = null,
    supportingContent: (@Composable () -> Unit)? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    prefix: (@Composable () -> Unit)? = null,
    suffix: (@Composable () -> Unit)? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    isError: Boolean = false,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    style: AppTextFieldStyle = AppTextFieldStyle.Outlined,
    size: AppTextFieldSize = AppTextFieldSize.Standard,
    shape: Shape = MaterialTheme.shapes.medium,
    textStyle: TextStyle = if (size == AppTextFieldSize.Compact) {
        MaterialTheme.typography.bodyMedium
    } else {
        MaterialTheme.typography.bodyLarge
    },
    colors: TextFieldColors? = null,
    contentPadding: PaddingValues = when (size) {
        AppTextFieldSize.Compact -> PaddingValues(horizontal = 12.dp, vertical = 4.dp)
        AppTextFieldSize.Standard -> PaddingValues(16.dp)
    },
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource? = null,
    focusedBorderThickness: Dp = OutlinedTextFieldDefaults.FocusedBorderThickness,
    unfocusedBorderThickness: Dp = OutlinedTextFieldDefaults.UnfocusedBorderThickness,
) {
    require(minLines >= 1) { "minLines must be at least 1" }
    require(maxLines >= minLines) { "maxLines must be greater than or equal to minLines" }

    val actualInteractionSource = interactionSource ?: remember { MutableInteractionSource() }
    val actualColors = colors ?: when (style) {
        AppTextFieldStyle.Filled -> TextFieldDefaults.colors()
        AppTextFieldStyle.Outlined -> OutlinedTextFieldDefaults.colors()
    }
    val focused by actualInteractionSource.collectIsFocusedAsState()
    val textColor = when {
        !enabled -> actualColors.disabledTextColor
        isError -> actualColors.errorTextColor
        focused -> actualColors.focusedTextColor
        else -> actualColors.unfocusedTextColor
    }
    val minHeight = when (size) {
        AppTextFieldSize.Compact -> AppThemeTokens.dimensions.compactTextFieldHeight
        AppTextFieldSize.Standard -> AppThemeTokens.dimensions.textFieldHeight
    }
    val actualLabel: (@Composable () -> Unit)? = labelContent ?: label?.let { value -> { Text(value) } }
    val actualPlaceholder: (@Composable () -> Unit)? = placeholderContent ?: placeholder?.let { value -> { Text(value) } }
    val actualSupporting: (@Composable () -> Unit)? = supportingContent ?: supportingText?.let { value -> { Text(value) } }

    CompositionLocalProvider(LocalTextSelectionColors provides actualColors.textSelectionColors) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.heightIn(min = minHeight),
            enabled = enabled,
            readOnly = readOnly,
            textStyle = textStyle.merge(TextStyle(color = textColor)),
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            visualTransformation = visualTransformation,
            interactionSource = actualInteractionSource,
            cursorBrush = SolidColor(if (isError) actualColors.errorCursorColor else actualColors.cursorColor),
            decorationBox = { innerTextField ->
                when (style) {
                    AppTextFieldStyle.Filled -> TextFieldDefaults.DecorationBox(
                        value = value,
                        innerTextField = innerTextField,
                        enabled = enabled,
                        singleLine = singleLine,
                        visualTransformation = visualTransformation,
                        interactionSource = actualInteractionSource,
                        isError = isError,
                        label = actualLabel,
                        placeholder = actualPlaceholder,
                        leadingIcon = leadingIcon,
                        trailingIcon = trailingIcon,
                        prefix = prefix,
                        suffix = suffix,
                        supportingText = actualSupporting,
                        shape = shape,
                        colors = actualColors,
                        contentPadding = contentPadding,
                    )
                    AppTextFieldStyle.Outlined -> OutlinedTextFieldDefaults.DecorationBox(
                        value = value,
                        innerTextField = innerTextField,
                        enabled = enabled,
                        singleLine = singleLine,
                        visualTransformation = visualTransformation,
                        interactionSource = actualInteractionSource,
                        isError = isError,
                        label = actualLabel,
                        placeholder = actualPlaceholder,
                        leadingIcon = leadingIcon,
                        trailingIcon = trailingIcon,
                        prefix = prefix,
                        suffix = suffix,
                        supportingText = actualSupporting,
                        colors = actualColors,
                        contentPadding = contentPadding,
                        container = {
                            OutlinedTextFieldDefaults.Container(
                                enabled = enabled,
                                isError = isError,
                                interactionSource = actualInteractionSource,
                                colors = actualColors,
                                shape = shape,
                                focusedBorderThickness = focusedBorderThickness,
                                unfocusedBorderThickness = unfocusedBorderThickness,
                            )
                        },
                    )
                }
            },
        )
    }
}
