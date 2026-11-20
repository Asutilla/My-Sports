package com.example.mysports.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mysports.data.SportsRepository
import com.example.mysports.navigation.Screen
import com.example.mysports.navigation.topLevelDestinations
import com.example.mysports.ui.components.SportsBottomBar
import com.example.mysports.ui.components.SportsTopBar
import com.example.mysports.ui.screens.AccountScreen
import com.example.mysports.ui.screens.HomeScreen
import com.example.mysports.ui.screens.MySportsScreen
import com.example.mysports.ui.screens.ProfileScreen
import com.example.mysports.ui.screens.SportDetailScreen

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val activeRoute = navBackStackEntry?.destination?.route ?: Screen.Home.route

    val title = when {
        activeRoute == Screen.Home.route -> Screen.Home.title
        activeRoute == Screen.Account.route -> Screen.Account.title
        activeRoute == Screen.Profile.route -> Screen.Profile.title
        activeRoute == Screen.MySports.route -> Screen.MySports.title
        activeRoute.startsWith("sport_detail") -> {
            val sportId = navBackStackEntry?.arguments?.getString("sportId")
            sportId?.let { SportsRepository.getSportById(it)?.name } ?: "Sport Detail"
        }
        else -> "My Sports"
    }

    val isTopLevelDestination = topLevelDestinations.any { it.route == activeRoute }
    val canNavigateBack = !isTopLevelDestination && navController.previousBackStackEntry != null

    Scaffold(
        topBar = {
            SportsTopBar(
                title = title,
                canNavigateBack = canNavigateBack,
                onNavigateBack = { navController.navigateUp() }
            )
        },
        bottomBar = {
            if (isTopLevelDestination) {
                SportsBottomBar(
                    currentRoute = activeRoute,
                    onNavigateToDestination = { screen ->
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen()
            }
            composable(Screen.Account.route) {
                AccountScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
            composable(Screen.MySports.route) {
                MySportsScreen(
                    onSportClick = { sportId ->
                        navController.navigate(Screen.SportDetail.createRoute(sportId))
                    }
                )
            }
            composable(
                route = Screen.SportDetail.route,
                arguments = listOf(
                    navArgument("sportId") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val sportId = backStackEntry.arguments?.getString("sportId") ?: ""
                SportDetailScreen(sportId = sportId)
            }
        }
    }
}
