package com.uzuu.base_myproject_jetpackcompose.ui.component.navigation

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailDefaults
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemColors
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AppNavigationRail(
    modifier: Modifier = Modifier,
    containerColor: Color = NavigationRailDefaults.ContainerColor,
    contentColor: Color = androidx.compose.material3.contentColorFor(containerColor),
    header: (@Composable ColumnScope.() -> Unit)? = null,
    windowInsets: WindowInsets = NavigationRailDefaults.windowInsets,
    content: @Composable ColumnScope.() -> Unit,
) = NavigationRail(
    modifier = modifier,
    containerColor = containerColor,
    contentColor = contentColor,
    header = header,
    windowInsets = windowInsets,
    content = content,
)

@Composable
fun AppNavigationRail(
    items: List<AppNavigationItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    header: (@Composable ColumnScope.() -> Unit)? = null,
    colors: NavigationRailItemColors = NavigationRailItemDefaults.colors(),
    containerColor: Color = NavigationRailDefaults.ContainerColor,
    contentColor: Color = androidx.compose.material3.contentColorFor(containerColor),
    windowInsets: WindowInsets = NavigationRailDefaults.windowInsets,
) = AppNavigationRail(
    modifier = modifier,
    containerColor = containerColor,
    contentColor = contentColor,
    header = header,
    windowInsets = windowInsets,
) {
    items.forEachIndexed { index, item ->
        NavigationRailItem(
            selected = index == selectedIndex,
            onClick = { onItemSelected(index) },
            icon = { AppNavigationIcon(item, index == selectedIndex) },
            label = { Text(item.label) },
            enabled = item.enabled,
            alwaysShowLabel = item.alwaysShowLabel,
            colors = colors,
        )
    }
}

