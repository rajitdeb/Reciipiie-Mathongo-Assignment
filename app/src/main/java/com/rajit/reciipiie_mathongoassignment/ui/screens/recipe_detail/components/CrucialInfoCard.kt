package com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CrucialInfoCard(title: String, value: String) {
    Card(
        border = BorderStroke(1.dp, Color(0xFFE7F0F8)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .width(100.dp)
                .padding(horizontal = 10.dp, vertical = 8.dp)
        ) {
            Text(title, color = Color(0xFF606F89), fontSize = 12.sp)
            Text(
                value,
                color = Color(0xFFE54900),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}