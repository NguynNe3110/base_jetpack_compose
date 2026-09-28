package com.uzuu.base_myproject_jetpackcompose.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import com.uzuu.base_myproject_jetpackcompose.ui.component.button.AppButton
import com.uzuu.base_myproject_jetpackcompose.ui.component.button.AppButtonStyle
import com.uzuu.base_myproject_jetpackcompose.ui.component.button.AppExtendedFloatingActionButton
import com.uzuu.base_myproject_jetpackcompose.ui.component.button.AppIconButton
import com.uzuu.base_myproject_jetpackcompose.ui.component.button.AppIconButtonStyle
import com.uzuu.base_myproject_jetpackcompose.ui.component.display.AppCard
import com.uzuu.base_myproject_jetpackcompose.ui.component.display.AppCardStyle
import com.uzuu.base_myproject_jetpackcompose.ui.component.display.AppChip
import com.uzuu.base_myproject_jetpackcompose.ui.component.display.AppChipStyle
import com.uzuu.base_myproject_jetpackcompose.ui.component.display.AppDivider
import com.uzuu.base_myproject_jetpackcompose.ui.component.display.AppListItem
import com.uzuu.base_myproject_jetpackcompose.ui.component.input.AppCheckbox
import com.uzuu.base_myproject_jetpackcompose.ui.component.input.AppRadioButton
import com.uzuu.base_myproject_jetpackcompose.ui.component.input.AppSlider
import com.uzuu.base_myproject_jetpackcompose.ui.component.input.AppSwitch
import com.uzuu.base_myproject_jetpackcompose.ui.component.input.AppTextField
import com.uzuu.base_myproject_jetpackcompose.ui.component.layout.AppScaffold
import com.uzuu.base_myproject_jetpackcompose.ui.component.navigation.AppNavigationBar
import com.uzuu.base_myproject_jetpackcompose.ui.component.navigation.AppNavigationItem
import com.uzuu.base_myproject_jetpackcompose.ui.component.navigation.AppTopAppBar
import com.uzuu.base_myproject_jetpackcompose.ui.theme.AppTheme
import com.uzuu.base_myproject_jetpackcompose.ui.theme.AppThemeTokens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentCatalogScreen() {
    var selectedNavigation by remember { mutableIntStateOf(0) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val navigationItems = remember {
        listOf(
            AppNavigationItem("Home", Icons.Outlined.Home),
            AppNavigationItem("Alerts", Icons.Outlined.Notifications),
            AppNavigationItem("Profile", Icons.Outlined.Person),
        )
    }

    AppScaffold(
        topBar = {
            AppTopAppBar(
                title = "App UI Kit",
                actions = {
                    AppIconButton(onClick = {}, style = AppIconButtonStyle.Standard) {
                        Icon(Icons.Outlined.MoreVert, "More")
                    }
                },
            )
        },
        bottomBar = {
            AppNavigationBar(navigationItems, selectedNavigation, { selectedNavigation = it })
        },
        snackbarHostState = snackbarHostState,
        floatingActionButton = {
            AppExtendedFloatingActionButton(
                text = { Text("Create") },
                icon = { Icon(Icons.Outlined.Add, null) },
                onClick = { scope.launch { snackbarHostState.showSnackbar("Action completed") } },
            )
        },
    ) { padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = padding,
            verticalArrangement = Arrangement.spacedBy(AppThemeTokens.spacing.md),
        ) {
            item { CatalogSection("Buttons") { ButtonSamples() } }
            item { CatalogSection("Inputs") { InputSamples() } }
            item { CatalogSection("Cards & chips") { DisplaySamples() } }
            item { Spacer(Modifier.height(AppThemeTokens.spacing.xxl)) }
        }
    }
}

@Composable
private fun CatalogSection(title: String, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = AppThemeTokens.spacing.md),
        verticalArrangement = Arrangement.spacedBy(AppThemeTokens.spacing.sm),
    ) {
        Text(title, style = AppThemeTokens.typography.titleLarge)
        content()
    }
}

@Composable
private fun ButtonSamples() {
    FlowRow(horizontalArrangement = Arrangement.spacedBy(AppThemeTokens.spacing.sm)) {
        AppButtonStyle.entries.forEach { AppButton(it.name, onClick = {}, style = it) }
        AppButton("Disabled", onClick = {}, enabled = false)
        AppIconButton(onClick = {}, style = AppIconButtonStyle.Tonal) {
            Icon(Icons.Outlined.FavoriteBorder, "Favorite")
        }
    }
}

@Composable
private fun InputSamples() {
    var text by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var radio by remember { mutableStateOf(false) }
    var slider by remember { mutableFloatStateOf(.35f) }
    AppTextField(
        value = text,
        onValueChange = { text = it },
        modifier = Modifier.fillMaxWidth(),
        label = "Label",
        placeholder = "Enter a value",
        supportingText = "Supporting text",
        singleLine = true,
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(AppThemeTokens.spacing.sm),
    ) {
        AppCheckbox(checked, { checked = it })
        AppSwitch(checked, { checked = it })
        AppRadioButton(radio, { radio = !radio })
    }
    AppSlider(slider, { slider = it }, modifier = Modifier.fillMaxWidth())
}

@Composable
private fun DisplaySamples() {
    AppCard(style = AppCardStyle.Elevated, modifier = Modifier.fillMaxWidth()) {
        AppListItem(
            headline = "Reusable component",
            supportingText = "All visual defaults come from AppTheme tokens.",
            leadingContent = { Icon(Icons.Outlined.Home, null) },
        )
        AppDivider()
        FlowRow(
            modifier = Modifier.padding(AppThemeTokens.spacing.md),
            horizontalArrangement = Arrangement.spacedBy(AppThemeTokens.spacing.sm),
        ) {
            AppChip({}, { Text("Assist") })
            AppChip({}, { Text("Filter") }, style = AppChipStyle.Filter, selected = true)
            AppChip({}, { Text("Suggestion") }, style = AppChipStyle.Suggestion)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ComponentCatalogPreview() = AppTheme { ComponentCatalogScreen() }
