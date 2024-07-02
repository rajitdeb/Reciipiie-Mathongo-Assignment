package com.rajit.reciipiie_mathongoassignment.ui.screens.search.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Fastfood
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchResultListItem(
    currentRecipe: String = "Shahi Paneer",
    onItemClicked: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clickable(onClick = {
                onItemClicked()
            })
    ) {
        Icon(
            imageVector = Icons.Outlined.Fastfood,
            contentDescription = "Recipe Icon"
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            currentRecipe,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}