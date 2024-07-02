package com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun CollapsibleListItemsSection() {
    Column {
        CollapsibleListItem(sectionTitle = "Nutrition")
        Spacer(modifier = Modifier.height(4.dp))
        CollapsibleListItem(sectionTitle = "Bad for health nutrition")
        Spacer(modifier = Modifier.height(4.dp))
        CollapsibleListItem(sectionTitle = "Good for health nutrition")
        Spacer(modifier = Modifier.height(24.dp))
    }
}