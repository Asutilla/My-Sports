package com.example.mysports.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mysports.navigation.Screen
import com.example.mysports.navigation.topLevelDestinations

@Composable
fun SportsBottomBar(
    currentRoute: String?,
    onNavigateToDestination: (Screen) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        topLevelDestinations.forEach { screen ->
            val isSelected = currentRoute == screen.route

            NavigationBarItem(
                selected = isSelected,
                onClick = { onNavigateToDestination(screen) },
                icon = {
                    screen.icon?.let { iconVector ->
                        Icon(
                            imageVector = iconVector,
                            contentDescription = screen.title
                        )
                    }
                },
                label = {
                    Text(text = screen.title)
                }
            )
        }
    }
}
