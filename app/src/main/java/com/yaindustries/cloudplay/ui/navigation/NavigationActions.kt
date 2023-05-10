package com.yaindustries.cloudplay.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.navigation.NavController
import com.yaindustries.cloudplay.ui.models.NavigationItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

class NavigationActions(private val navController: NavController) {
    private val navigateToHomeScreen: () -> Unit = {
        navController.navigate(NavigationDestinations.HOME_ROUTE) {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    private val navigateToSearchScreen: () -> Unit = {
        navController.navigate(NavigationDestinations.SEARCH_ROUTE) {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    private val navigateToSettingsScreen: () -> Unit = {
        navController.navigate(NavigationDestinations.SETTINGS_ROUTE) {
            launchSingleTop = true
        }
    }

    val bottomBarItems: ImmutableList<NavigationItem> = persistentListOf(
        NavigationItem(
            activeIcon = Icons.Filled.Home,
            passiveIcon = Icons.Outlined.Home,
            label = "Home",
            route = NavigationDestinations.HOME_ROUTE,
            onClick = navigateToHomeScreen
        ),
        NavigationItem(
            activeIcon = Icons.Filled.Search,
            passiveIcon = Icons.Outlined.Search,
            label = "Search",
            route = NavigationDestinations.SEARCH_ROUTE,
            onClick = navigateToSearchScreen
        )
    )
}