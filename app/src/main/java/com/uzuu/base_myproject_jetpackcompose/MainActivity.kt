package com.uzuu.base_myproject_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.core.view.WindowCompat
import com.uzuu.base_myproject_jetpackcompose.feature.ComponentCatalogScreen
import com.uzuu.base_myproject_jetpackcompose.feature.ComponentPlaygroundScreen
import com.uzuu.base_myproject_jetpackcompose.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AppTheme {
                var showPlayground by rememberSaveable { mutableStateOf(false) }
                BackHandler(enabled = showPlayground) { showPlayground = false }
                if (showPlayground) {
                    ComponentPlaygroundScreen(onBack = { showPlayground = false })
                } else {
                    ComponentCatalogScreen(onOpenPlayground = { showPlayground = true })
                }
            }
        }
    }
}
