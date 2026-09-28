package com.uzuu.base_myproject_jetpackcompose.ui.component.button

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

enum class AppFabSize { Small, Regular, Large }

@Composable
fun AppFloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: AppFabSize = AppFabSize.Regular,
    shape: Shape = when (size) {
        AppFabSize.Small -> MaterialTheme.shapes.medium
        AppFabSize.Regular -> MaterialTheme.shapes.large
        AppFabSize.Large -> MaterialTheme.shapes.extraLarge
    },
    containerColor: Color = FloatingActionButtonDefaults.containerColor,
    contentColor: Color = androidx.compose.material3.contentColorFor(containerColor),
    content: @Composable () -> Unit,
) = when (size) {
    AppFabSize.Small -> SmallFloatingActionButton(onClick, modifier, shape, containerColor, contentColor, content = content)
    AppFabSize.Regular -> FloatingActionButton(onClick, modifier, shape, containerColor, contentColor, content = content)
    AppFabSize.Large -> LargeFloatingActionButton(onClick, modifier, shape, containerColor, contentColor, content = content)
}

@Composable
fun AppExtendedFloatingActionButton(
    text: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = true,
) = ExtendedFloatingActionButton(text, icon, onClick, modifier, expanded)

