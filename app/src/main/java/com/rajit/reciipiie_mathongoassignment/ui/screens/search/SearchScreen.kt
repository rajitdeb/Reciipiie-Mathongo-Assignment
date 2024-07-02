package com.rajit.reciipiie_mathongoassignment.ui.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rajit.reciipiie_mathongoassignment.util.AppConstants
import com.rajit.reciipiie_mathongoassignment.ui.screens.home.components.SearchBarView
import com.rajit.reciipiie_mathongoassignment.ui.screens.search.components.SearchRecipeResultBottomSheet
import com.rajit.reciipiie_mathongoassignment.ui.screens.search.components.SearchResultListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onBackClicked: () -> Unit,
    onSimilarRecipeClicked: (String) -> Unit
) {
    var showBottomSheet by remember { mutableStateOf(true) }
    var showIngredientBottomSheet by remember { mutableStateOf(true) }
    var clickedRecipe: String? by remember {
        mutableStateOf(null)
    }
    val mSheetScaffoldState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        sheetSwipeEnabled = false,
        scaffoldState = mSheetScaffoldState,
        sheetDragHandle = null,
        sheetContent = {
            if (showBottomSheet && clickedRecipe != null) {
                SearchRecipeResultBottomSheet(
                    currentRecipe = clickedRecipe!!,
                    onDismiss = { showBottomSheet = false },
                    onMarkedFavourite = { showIngredientBottomSheet = true },
                    onSimilarRecipeItemClicked = { onSimilarRecipeClicked(it) }
                )
            }
        },
        sheetPeekHeight = 0.dp,
//        modifier = Modifier.padding(innerPadding)
    ) {
        Column(
            Modifier.padding(
                start = 16.dp,
                end = 16.dp
            )
        ) {
            SearchBarView(isFunctional = true, onBackClicked = { onBackClicked() })
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn {
                items(AppConstants.sampleTextList.size) { pos ->
                    val currentRecipe = AppConstants.sampleTextList[pos]
                    SearchResultListItem(
                        currentRecipe,
                        onItemClicked = {
                            clickedRecipe = currentRecipe
                            showBottomSheet = true
                        },
                    )
                }
            }

        }
    }
}