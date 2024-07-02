package com.rajit.reciipiie_mathongoassignment.ui.screens.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {

    @Serializable
    data object Login: Screen()

    @Serializable
    data object Home: Screen()

    @Serializable
    data object Favourite: Screen()

    @Serializable
    data object Search: Screen()

    @Serializable
    data class RecipeDetail(val currentRecipe: String): Screen()

}