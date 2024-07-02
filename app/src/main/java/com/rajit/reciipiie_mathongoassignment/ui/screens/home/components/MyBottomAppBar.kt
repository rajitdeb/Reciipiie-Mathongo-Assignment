package com.rajit.reciipiie_mathongoassignment.ui.screens.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.rajit.reciipiie_mathongoassignment.ui.screens.navigation.Screen

@Composable
fun MyBottomAppBar(
    navController: NavHostController,
    currentBackStackEntry: NavBackStackEntry?
) {

    val currentRoute = currentBackStackEntry?.destination?.route

    if (currentRoute != null &&
        (currentRoute.contains("Home") || currentRoute.contains("Favourite"))) {

        NavigationBar(containerColor = Color.White) {
            // Home
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "",
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFE54900),
                    selectedTextColor = Color(0xFFE54900),
                    indicatorColor = Color(0xFFF8CCB6)
                ),
                alwaysShowLabel = true,
                selected = currentRoute.contains("Home"),
                label = { Text("Home") },
                onClick = { navController.navigate(Screen.Home) }
            )

            // Favourite
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = ""
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFFE54900),
                    selectedTextColor = Color(0xFFE54900),
                    indicatorColor = Color(0xFFF8CCB6)
                ),
                selected = currentRoute.contains("Favourite"),
                label = { Text("Favourite") },
                onClick = { navController.navigate(Screen.Favourite) }
            )
        }
    }
}