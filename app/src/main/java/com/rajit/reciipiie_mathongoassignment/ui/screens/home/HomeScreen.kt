package com.rajit.reciipiie_mathongoassignment.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rajit.reciipiie_mathongoassignment.util.AppConstants
import com.rajit.reciipiie_mathongoassignment.ui.screens.home.components.AllRecipesListWithHeader
import com.rajit.reciipiie_mathongoassignment.ui.screens.home.components.GreetingText
import com.rajit.reciipiie_mathongoassignment.ui.screens.home.components.PopularRecipeCarouselWithHeader
import com.rajit.reciipiie_mathongoassignment.ui.screens.home.components.SearchBarView

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(
    onRecipeClicked: (String) -> Unit = {},
    onSearchClicked: () -> Unit = {}
) {
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Greeting Text and TagLine Section
        GreetingText()

        Spacer(modifier = Modifier.height(16.dp))

        // Search Bar View (Clickable)
        SearchBarView(
            isFunctional = false,
            onSearchClicked = { onSearchClicked() },
            onBackClicked = {}
        )

        Spacer(Modifier.height(24.dp))

        // Popular Recipes Section
        PopularRecipeCarouselWithHeader(recipeList = AppConstants.sampleTextList)

        Spacer(modifier = Modifier.height(24.dp))

        // All Recipes Section
        AllRecipesListWithHeader(
            recipesList = AppConstants.sampleTextList,
            onRecipeClicked = { onRecipeClicked(it) }
        )
    }
}