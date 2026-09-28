package com.uzuu.base_myproject_jetpackcompose.ui.component.navigation

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppNavigationRail(
    items: List<AppNavigationItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    header: (@Composable ColumnScope.() -> Unit)? = null,
) = NavigationRail(modifier = modifier, header = header) {
    items.forEachIndexed { index, item ->
        NavigationRailItem(
            selected = index == selectedIndex,
            onClick = { onItemSelected(index) },
            icon = { Icon(if (index == selectedIndex) item.selectedIcon else item.icon, item.label) },
            label = { Text(item.label) },
        )
    }
}

