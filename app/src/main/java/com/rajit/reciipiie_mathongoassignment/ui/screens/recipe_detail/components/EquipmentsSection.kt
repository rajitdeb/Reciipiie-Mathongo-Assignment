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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajit.reciipiie_mathongoassignment.util.AppConstants

@Composable
fun EquipmentsSection() {
    Text(
        "Equipments",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 16.dp)
    )
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(start = 16.dp)
    ) {
        items(AppConstants.sampleEquipments.size) { pos ->
            val currentEquipment = AppConstants.sampleEquipments[pos]
            EquipmentCard(equipment = currentEquipment)
        }
    }
}