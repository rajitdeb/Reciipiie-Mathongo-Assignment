package com.rajit.reciipiie_mathongoassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rajit.reciipiie_mathongoassignment.ui.screens.home.components.MyBottomAppBar
import com.rajit.reciipiie_mathongoassignment.ui.screens.home.components.MyTopAppBar
import com.rajit.reciipiie_mathongoassignment.ui.screens.navigation.MyNavHost
import com.rajit.reciipiie_mathongoassignment.ui.theme.ReciipiieMathongoAssignmentTheme
import com.rajit.reciipiie_mathongoassignment.viewmodel.RecipeViewModel
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReciipiieMathongoAssignmentTheme {
                MyScaffold()
            }
        }
    }
}

@Composable
fun MyScaffold(viewModel: RecipeViewModel = getViewModel()) {

    // ViewModel Check
    viewModel.isALlOk()

    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            MyTopAppBar(
                navController = navController,
                currentBackStackEntry = currentBackStackEntry
            )
        },
        bottomBar = {
            MyBottomAppBar(
                navController = navController,
                currentBackStackEntry = currentBackStackEntry
            )
        },
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            MyNavHost(navController = navController)
        }
    }
}