package com.uzuu.base_myproject_jetpackcompose.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Screen(){
    Surface(
        modifier = Modifier.background(Color.White).fillMaxSize()
    ){
        Text("Screen")
    }
}


@Preview(showBackground = true)
// 1. Phone nhỏ - Compact
@Preview(
    name = "Small Phone",
    device = Devices.PHONE
)

// 2. Phone lớn - Compact/Medium boundary
@Preview(
    name = "Large Phone - Portrait",
    device = Devices.PIXEL_6_PRO
)

// 3. Phone Landscape - Compact
//@Preview(
//    name = "Phone - Landscape",
//    device = Devices.PHONE,
//    showBackground = true,
//    uiMode = android.content.res.Configuration.UI_MODE_ORIENTATION_LANDSCAPE
//)

// 4. Tablet nhỏ - Medium
@Preview(
    name = "Small Tablet",
    device = Devices.NEXUS_7
)

// 5. Tablet lớn - Expanded
@Preview(
    name = "Large Tablet",
    device = Devices.PIXEL_C
)

// 6. Foldable - Medium/Expanded
@Preview(
    name = "Foldable",
    device = Devices.FOLDABLE
)

// 7. Desktop - Medium/Expanded
@Preview(
    name = "DESKTOP",
    device = Devices.DESKTOP
)
@Composable
fun PreviewScreen() {
    Screen()
}