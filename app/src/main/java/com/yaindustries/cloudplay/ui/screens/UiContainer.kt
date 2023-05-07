package com.yaindustries.cloudplay.ui.screens


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.yaindustries.cloudplay.ui.navigation.BottomNavigationBar
import com.yaindustries.cloudplay.ui.navigation.NavGraph
import com.yaindustries.cloudplay.ui.navigation.NavigationActions
import com.yaindustries.cloudplay.ui.theme.CloudPlayTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiContainer() {
    CloudPlayTheme {
        val navController = rememberNavController()
        val navigationActions = NavigationActions(navController)

        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    bottomBarItems = navigationActions.bottomBarItems,
                    navController = navController
                )
            },
            content = { NavGraph(paddingValues = it, navController = navController) }
        )
    }
}