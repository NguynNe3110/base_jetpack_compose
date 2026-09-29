package com.uzuu.base_myproject_jetpackcompose.ui.component.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomAppBarScrollBehavior
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomAppBar(
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit,
    floatingActionButton: @Composable (() -> Unit)? = null,
    containerColor: Color = BottomAppBarDefaults.containerColor,
    contentColor: Color = androidx.compose.material3.contentColorFor(containerColor),
    tonalElevation: Dp = BottomAppBarDefaults.ContainerElevation,
    contentPadding: PaddingValues = BottomAppBarDefaults.ContentPadding,
    windowInsets: WindowInsets = BottomAppBarDefaults.windowInsets,
    scrollBehavior: BottomAppBarScrollBehavior? = null,
) = BottomAppBar(
    actions = actions,
    modifier = modifier,
    floatingActionButton = floatingActionButton,
    containerColor = containerColor,
    contentColor = contentColor,
    tonalElevation = tonalElevation,
    contentPadding = contentPadding,
    windowInsets = windowInsets,
    scrollBehavior = scrollBehavior,
)
