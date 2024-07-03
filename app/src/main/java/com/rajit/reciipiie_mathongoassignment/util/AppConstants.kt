package com.rajit.reciipiie_mathongoassignment.util

import com.rajit.reciipiie_mathongoassignment.R
import com.rajit.reciipiie_mathongoassignment.model.Equipment
import com.rajit.reciipiie_mathongoassignment.model.Ingredients

object AppConstants {

    val apiKey = "41e9ae27ea474fbdb6cd35e4aa424637"
    val BASE_URL = "https://api.spoonacular.com/"

    val sampleTextList = listOf<String>(
        "Shahi Paneer",
        "Paneer Kureta",
        "Chur Chur Naan",
        "Chole Kulche",
        "Lachha Paratha",
        "Dahi Bhalla",
    )

    val sampleIngredients: List<Ingredients> = listOf(
        Ingredients("Onion", R.drawable.onion),
        Ingredients("Paneer", R.drawable.raw_paneer),
        Ingredients("Butter", R.drawable.butter),
        Ingredients("Ginger", R.drawable.ginger),
    )

    val sampleEquipments: List<Equipment> = listOf(
        Equipment(imgLink = "Equipment Img Link", name = "Equipment Name"),
        Equipment(imgLink = "Equipment Img Link", name = "Equipment Name"),
    )

}