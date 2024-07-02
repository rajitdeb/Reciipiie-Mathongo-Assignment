package com.rajit.reciipiie_mathongoassignment.ui.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingText() {
    Column {
        Text(
            "👋 Hey <user first name>",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Discover tasty and healthy recipe",
            fontSize = 13.sp,
            color = Color(0xFF727881)
        )
    }
}