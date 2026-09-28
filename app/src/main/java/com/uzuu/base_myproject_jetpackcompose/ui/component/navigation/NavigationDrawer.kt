package com.uzuu.base_myproject_jetpackcompose.ui.component.navigation

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppNavigationDrawer(
    drawerState: DrawerState,
    items: List<AppNavigationItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    gesturesEnabled: Boolean = true,
    header: (@Composable ColumnScope.() -> Unit)? = null,
    content: @Composable () -> Unit,
) = ModalNavigationDrawer(
    drawerContent = {
        ModalDrawerSheet {
            header?.invoke(this)
            items.forEachIndexed { index, item ->
                NavigationDrawerItem(
                    label = { Text(item.label) },
                    selected = index == selectedIndex,
                    onClick = { onItemSelected(index) },
                    icon = { Icon(if (index == selectedIndex) item.selectedIcon else item.icon, item.label) },
                )
            }
        }
    },
    modifier = modifier,
    drawerState = drawerState,
    gesturesEnabled = gesturesEnabled,
    content = content,
)

