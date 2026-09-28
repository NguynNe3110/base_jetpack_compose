package com.uzuu.base_myproject_jetpackcompose.ui.component.navigation

import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppTabRow(
    titles: List<String>,
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    scrollable: Boolean = false,
) {
    val tabs: @Composable () -> Unit = {
        titles.forEachIndexed { index, title ->
            Tab(
                selected = selectedIndex == index,
                onClick = { onTabSelected(index) },
                text = { Text(title) },
            )
        }
    }
    if (scrollable) PrimaryScrollableTabRow(selectedIndex, modifier = modifier, tabs = tabs)
    else PrimaryTabRow(selectedIndex, modifier = modifier, tabs = tabs)
}
