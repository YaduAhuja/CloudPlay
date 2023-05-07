package com.yaindustries.cloudplay.ui.models

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val activeIcon: ImageVector,
    val passiveIcon : ImageVector,
    val label: String,
    val route : String,
    val onClick : () -> Unit
)
