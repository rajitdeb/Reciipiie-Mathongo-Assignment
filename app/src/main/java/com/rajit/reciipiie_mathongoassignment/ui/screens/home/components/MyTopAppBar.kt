package com.rajit.reciipiie_mathongoassignment.ui.screens.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    navController: NavHostController,
    currentBackStackEntry: NavBackStackEntry?
) {

    val currentRoute = currentBackStackEntry?.destination?.route

    if (currentRoute != null && currentRoute.contains("RecipeDetail")) {
        TopAppBar(
            title = { Text("Recipe Detail") },
            navigationIcon = {
                IconButton(
                    onClick = { navController.navigateUp() }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Up Button"
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFEB4900),
                navigationIconContentColor = Color.White,
                titleContentColor = Color.White
            )
        )
    }
}