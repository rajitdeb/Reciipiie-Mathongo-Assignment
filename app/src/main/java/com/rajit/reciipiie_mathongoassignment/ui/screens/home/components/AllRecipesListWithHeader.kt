package com.rajit.reciipiie_mathongoassignment.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
fun AllRecipesListWithHeader(
    recipesList: List<String>,
    onRecipeClicked: (String) -> Unit
) {
    Column {
        Text(
            text = "All Recipes",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(recipesList) { currentItem ->
                // List Item
                RecipeVerticalListItem(
                    currentItem = currentItem,
                    onItemClicked = { onRecipeClicked(currentItem) }
                )
            }
        }
    }
}