package com.rajit.reciipiie_mathongoassignment.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rajit.reciipiie_mathongoassignment.AppConstants
import com.rajit.reciipiie_mathongoassignment.ui.screens.favourite.FavouriteScreen
import com.rajit.reciipiie_mathongoassignment.ui.screens.home.HomeScreen
import com.rajit.reciipiie_mathongoassignment.ui.screens.login.LoginScreen
import com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.RecipeDetailScreen
import com.rajit.reciipiie_mathongoassignment.ui.screens.search.SearchScreen

@Composable
fun MyNavHost(
    navController: NavHostController,
    startDestination: Screen = Screen.Login
) {

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable<Screen.Login> {
            LoginScreen(onAuthClicked = {
                navController.popBackStack(Screen.Login, inclusive = true)
                navController.navigate(Screen.Home)
            })
        }

        composable<Screen.Home> {
            HomeScreen(
                onRecipeClicked = { clickedRecipe ->
                    navController.navigate(Screen.RecipeDetail(clickedRecipe))
                },
                onSearchClicked = { navController.navigate(Screen.Search) }
            )
        }

        composable<Screen.Favourite> {
            FavouriteScreen(
                recipeList = AppConstants.sampleTextList,
                onRecipeClicked = { clickedRecipe ->
                    navController.navigate(Screen.RecipeDetail(clickedRecipe))
                }
            )
        }

        composable<Screen.Search> {
            SearchScreen(
                onBackClicked = { navController.navigateUp() },
                onSimilarRecipeClicked = { clickedRecipe ->
                    navController.navigate(Screen.RecipeDetail(clickedRecipe))
                }
            )
        }

        composable<Screen.RecipeDetail> {
            RecipeDetailScreen(currentRecipe = "Paneer Kureta")
        }
    }

}