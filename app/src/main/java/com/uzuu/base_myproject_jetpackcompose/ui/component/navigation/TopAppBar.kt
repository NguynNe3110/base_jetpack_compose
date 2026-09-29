package com.uzuu.base_myproject_jetpackcompose.ui.component.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

enum class AppTopBarStyle { Small, Centered, Medium, Large }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    style: AppTopBarStyle = AppTopBarStyle.Small,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null,
) = when (style) {
    AppTopBarStyle.Small -> TopAppBar(title = title, modifier = modifier, navigationIcon = navigationIcon, actions = actions, colors = colors, scrollBehavior = scrollBehavior)
    AppTopBarStyle.Centered -> CenterAlignedTopAppBar(title = title, modifier = modifier, navigationIcon = navigationIcon, actions = actions, colors = colors, scrollBehavior = scrollBehavior)
    AppTopBarStyle.Medium -> MediumTopAppBar(title = title, modifier = modifier, navigationIcon = navigationIcon, actions = actions, colors = colors, scrollBehavior = scrollBehavior)
    AppTopBarStyle.Large -> LargeTopAppBar(title = title, modifier = modifier, navigationIcon = navigationIcon, actions = actions, colors = colors, scrollBehavior = scrollBehavior)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    style: AppTopBarStyle = AppTopBarStyle.Small,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(),
    scrollBehavior: TopAppBarScrollBehavior? = null,
) = AppTopAppBar(
    title = { Text(title) },
    modifier = modifier,
    style = style,
    navigationIcon = navigationIcon,
    actions = actions,
    colors = colors,
    scrollBehavior = scrollBehavior,
)
