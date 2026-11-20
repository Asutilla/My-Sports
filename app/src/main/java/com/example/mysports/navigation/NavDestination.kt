package com.example.mysports.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector? = null) {
    data object Home : Screen("home", "Home", Icons.Default.Home)
    data object Account : Screen("account", "Account", Icons.AutoMirrored.Filled.List)
    data object Profile : Screen("profile", "Profile", Icons.Default.AccountCircle)
    data object MySports : Screen("my_sports", "My Sports", Icons.Default.Star)

    data object SportDetail : Screen("sport_detail/{sportId}", "Sport Detail") {
        fun createRoute(sportId: String) = "sport_detail/$sportId"
    }
}

val topLevelDestinations: List<Screen>
    get() = listOf(
        Screen.Home,
        Screen.Account,
        Screen.Profile,
        Screen.MySports
    )
