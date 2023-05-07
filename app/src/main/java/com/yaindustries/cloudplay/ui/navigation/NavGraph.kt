package com.yaindustries.cloudplay.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.yaindustries.cloudplay.ui.screens.home.HomeScreen
import com.yaindustries.cloudplay.ui.screens.search.SearchScreen

@Composable
fun NavGraph(
    navController : NavHostController,
    paddingValues : PaddingValues,
    modifier : Modifier = Modifier,
    startDestination : String = NavigationDestinations.HOME_ROUTE
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(NavigationDestinations.HOME_ROUTE) {
            HomeScreen(paddingValues)
        }

        composable(NavigationDestinations.SEARCH_ROUTE) {
            SearchScreen(paddingValues)
        }
    }
}