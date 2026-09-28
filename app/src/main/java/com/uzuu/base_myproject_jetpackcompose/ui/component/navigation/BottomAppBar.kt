package com.uzuu.base_myproject_jetpackcompose.ui.component.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppBottomAppBar(
    modifier: Modifier = Modifier,
    actions: @Composable RowScope.() -> Unit,
    floatingActionButton: @Composable (() -> Unit)? = null,
) {
    if (floatingActionButton == null) {
        BottomAppBar(modifier = modifier, actions = actions)
    } else {
        BottomAppBar(modifier = modifier, actions = actions, floatingActionButton = floatingActionButton)
    }
}
