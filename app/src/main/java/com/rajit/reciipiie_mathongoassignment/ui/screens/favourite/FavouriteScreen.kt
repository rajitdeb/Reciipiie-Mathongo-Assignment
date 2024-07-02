package com.rajit.reciipiie_mathongoassignment.ui.screens.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajit.reciipiie_mathongoassignment.ui.screens.common_components.RecipeVerticalListItem

@Composable
fun FavouriteScreen(
    recipeList: List<String>,
    onRecipeClicked: (String) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    ) {
        item {
            Text(
                text = "Favourite Recipes",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        items(recipeList) { currentItem ->
            RecipeVerticalListItem(
                currentItem = currentItem,
                onItemClicked = {
                    onRecipeClicked(currentItem)
                }
            )
        }
    }
}