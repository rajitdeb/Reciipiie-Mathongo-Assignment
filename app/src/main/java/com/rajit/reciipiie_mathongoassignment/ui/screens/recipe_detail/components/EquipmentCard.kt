package com.rajit.reciipiie_mathongoassignment.ui.screens.recipe_detail.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajit.reciipiie_mathongoassignment.R
import com.rajit.reciipiie_mathongoassignment.model.Equipment

@Composable
fun EquipmentCard(equipment: Equipment) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(90.dp)
    ) {
        Card(
            shape = CircleShape,
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(
                width = 1.dp,
                color = Color(0xFFE0F7F8)
            )
        ) {

            Image(
                painter = painterResource(id = R.drawable.equipment_img),
                contentDescription = "${equipment.name} Equipment Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(90.dp)
                    .height(90.dp)
            )

        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            "Equipment Name",
            fontSize = 14.sp,
            color = Color(0xFF171B21),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}