package com.rajit.reciipiie_mathongoassignment.ui.screens.common_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajit.reciipiie_mathongoassignment.R

@Composable
fun RecipeVerticalListItem(
    currentItem: String,
    onItemClicked: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, Color(0xFFE7F0F8)),
        modifier = Modifier
            .height(120.dp)
            .clickable { onItemClicked() }
            .fillMaxWidth()
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.paneer),
                contentDescription = "$currentItem Recipe Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(120.dp)
                    .height(120.dp)
            )

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp)
            ) {
                // Recipe Name
                Text(
                    currentItem,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                // Total Recipe Time
                Text(
                    "Ready in 25 min",
                    fontSize = 13.sp,
                    color = Color(0xFF606F89)
                )
            }
        }
    }
}