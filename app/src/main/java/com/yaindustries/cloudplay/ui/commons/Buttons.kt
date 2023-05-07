package com.yaindustries.cloudplay.ui.commons

import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CPIconButton(onClick : () -> Unit, modifier: Modifier = Modifier, content : @Composable () -> Unit) {
    IconButton(
        onClick = onClick,
        content = content,
        modifier = modifier
    )
}