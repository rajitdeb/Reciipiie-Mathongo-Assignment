package com.rajit.reciipiie_mathongoassignment.ui.screens.search.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajit.reciipiie_mathongoassignment.util.AppConstants
import com.rajit.reciipiie_mathongoassignment.R
import com.rajit.reciipiie_mathongoassignment.ui.screens.common_components.RecipeVerticalListItem
import com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components.CollapsibleListItemsSection
import com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components.CrucialInfoSection
import com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components.EquipmentsSection
import com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components.IngredientsCard
import com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components.InstructionsSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchRecipeResultBottomSheet(
    currentRecipe: String,
    onDismiss: () -> Unit,
    onMarkedFavourite: () -> Unit,
    onSimilarRecipeItemClicked: (String) -> Unit
) {

    val mSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    var showIngredients by remember {
        mutableStateOf(false)
    }
    var showFullRecipe by remember {
        mutableStateOf(false)
    }
    var showSimilarRecipes by remember {
        mutableStateOf(false)
    }

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = mSheetState,
        containerColor = Color.White,
        modifier = Modifier.fillMaxHeight(0.8f)
    ) {
        Column {
            // Top Header -> Back Button, Recipe Title, Favourite Button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { onDismiss() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Close Bottom Sheet"
                        )
                    }

                    Text(
                        currentRecipe,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                IconButton(onClick = { onMarkedFavourite() }) {
                    Icon(
                        imageVector = Icons.Filled.FavoriteBorder,
                        contentDescription = "Close Bottom Sheet",
                        tint = Color(0xFFE54900)
                    )
                }
            }

            AnimatedVisibility(visible = !showIngredients) {
                Column {
                    // Recipe Image
                    Image(
                        painter = painterResource(id = R.drawable.paneer),
                        contentDescription = "$currentRecipe Recipe Image",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .height(320.dp)
                            .fillMaxWidth()
                    )

                    // Crucial Info Card
                    Column {
                        Spacer(Modifier.height(16.dp))
                        CrucialInfoSection()
                    }

                    Button(
                        onClick = { showIngredients = true },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFE54900)
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                "Get Ingredients",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }
            }
            Divider(thickness = 1.dp, color = Color(0xFFEFF0F0))
            AnimatedVisibility(visible = showIngredients) {
                Column {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            "Ingredients",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                        IconButton(onClick = { showIngredients = !showIngredients }) {
                            Icon(
                                imageVector = if (!showFullRecipe) Icons.Filled.KeyboardArrowUp
                                else Icons.Filled.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }
                    }
                    if (!showFullRecipe) {
                        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                            items(AppConstants.sampleIngredients) { currentIngredient ->
                                IngredientsCard(currentIngredient = currentIngredient)
                            }
                        }

                        Button(
                            onClick = { showFullRecipe = true },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFE54900)
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    "Get Full Recipe",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }

                    } else {
                        Divider(thickness = 1.dp, color = Color(0xFFEFF0F0))
                    }
                }
            }
            AnimatedVisibility(visible = showFullRecipe) {
                Column {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            "Full Recipe",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                        IconButton(onClick = { showFullRecipe = !showFullRecipe }) {
                            Icon(
                                imageVector = if (!showFullRecipe) Icons.Filled.KeyboardArrowUp
                                else Icons.Filled.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }
                    }
                    if (!showSimilarRecipes) {

                        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                            InstructionsSection()

                            Spacer(modifier = Modifier.height(24.dp))

                            // Equipments Section
                            EquipmentsSection()

                            Spacer(modifier = Modifier.height(24.dp))

                            // Quick Summary Section
                            CollapsibleListItemsSection()

                            Button(
                                onClick = { showSimilarRecipes = true },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFFE54900)
                                ),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier
                                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 16.dp)
                                    .fillMaxWidth()
                                    .height(50.dp)
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        "Get Similar Recipes",
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                                        contentDescription = null,
                                        tint = Color.White,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    } else {
                        Divider(thickness = 1.dp, color = Color(0xFFEFF0F0))
                    }
                }
            }
            AnimatedVisibility(visible = showSimilarRecipes) {
                Column {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            "Similar Recipes",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                        IconButton(onClick = { showSimilarRecipes = !showSimilarRecipes }) {
                            Icon(
                                imageVector = if (!showFullRecipe) Icons.Filled.KeyboardArrowUp
                                else Icons.Filled.KeyboardArrowDown,
                                contentDescription = null
                            )
                        }
                    }

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        items(AppConstants.sampleTextList.size) { pos ->
                            val currentRecipeItem = AppConstants.sampleTextList[pos]
                            RecipeVerticalListItem(
                                currentItem = currentRecipeItem,
                                onItemClicked = {
                                    onSimilarRecipeItemClicked(currentRecipeItem)
                                    // Also dismiss the bottom sheet
                                    onDismiss()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}