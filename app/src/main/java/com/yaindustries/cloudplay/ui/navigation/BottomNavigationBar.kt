package com.yaindustries.cloudplay.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.yaindustries.cloudplay.ui.models.NavigationItem
import kotlinx.collections.immutable.ImmutableList

@Composable
fun BottomNavigationBar(
    bottomBarItems: ImmutableList<NavigationItem>,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    NavigationBar(modifier = Modifier) {
        bottomBarItems.forEach { navigationItem ->
            val isSelected = backStackEntry?.destination?.route == navigationItem.route
            NavigationBarItem(
                icon = {
                    Icon(
                        if (isSelected) navigationItem.activeIcon else navigationItem.passiveIcon,
                        contentDescription = navigationItem.label
                    )
                },
                selected = isSelected,
                onClick = navigationItem.onClick,
                label = { Text(text = navigationItem.label) }
            )
        }
    }
}