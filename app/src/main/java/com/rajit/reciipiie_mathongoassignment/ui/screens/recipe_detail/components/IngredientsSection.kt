package com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajit.reciipiie_mathongoassignment.AppConstants

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IngredientsSection() {
    Text(
        "Ingredients",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 16.dp)
    )
    Spacer(modifier = Modifier.height(16.dp))
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(start = 16.dp)
    ) {
        items(AppConstants.sampleIngredients.size) { pos ->
            val currentIngredient = AppConstants.sampleIngredients[pos]
            IngredientsCard(currentIngredient = currentIngredient)
        }
    }
}