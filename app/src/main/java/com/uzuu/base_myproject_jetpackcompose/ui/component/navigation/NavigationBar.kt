package com.uzuu.base_myproject_jetpackcompose.ui.component.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
data class AppNavigationItem(
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector = icon,
    val badge: String? = null,
)

@Composable
fun AppNavigationBar(
    items: List<AppNavigationItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    colors: NavigationBarItemColors = NavigationBarItemDefaults.colors(),
) = NavigationBar(modifier = modifier) {
    items.forEachIndexed { index, item ->
        NavigationBarItem(
            selected = index == selectedIndex,
            onClick = { onItemSelected(index) },
            icon = { AppNavigationIcon(item, index == selectedIndex) },
            label = { Text(item.label) },
            colors = colors,
        )
    }
}

@Composable
internal fun AppNavigationIcon(item: AppNavigationItem, selected: Boolean) {
    val icon: @Composable () -> Unit = {
        Icon(if (selected) item.selectedIcon else item.icon, item.label)
    }
    if (item.badge == null) {
        icon()
    } else {
        BadgedBox(
            badge = {
                Badge {
                    if (item.badge.isNotEmpty()) Text(item.badge)
                }
            },
        ) { icon() }
    }
}

