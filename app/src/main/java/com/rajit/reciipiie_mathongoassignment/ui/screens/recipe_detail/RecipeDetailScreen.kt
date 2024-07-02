package com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components.CollapsibleListItemsSection
import com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components.CrucialInfoSection
import com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components.EquipmentsSection
import com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components.IngredientsSection
import com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components.InstructionsSection
import com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components.RecipeDetailImage

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecipeDetailScreen(currentRecipe: String) {
    Scaffold(containerColor = Color.White) { _ ->
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

            // Recipe Image
            RecipeDetailImage(currentRecipe = currentRecipe)

            Spacer(modifier = Modifier.height(16.dp))

            // Recipe Crucial Info
            // ReadyIn, Servings, Price per Serving
            CrucialInfoSection()

            Spacer(modifier = Modifier.height(24.dp))

            // Ingredients Section
            IngredientsSection()

            Spacer(modifier = Modifier.height(24.dp))

            // Instructions Section
            InstructionsSection()

            Spacer(modifier = Modifier.height(24.dp))

            // Equipments Section
            EquipmentsSection()

            Spacer(modifier = Modifier.height(24.dp))

            // Quick Summary Section
            CollapsibleListItemsSection()
        }
    }

}