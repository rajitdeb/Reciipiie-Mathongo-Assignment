package com.rajit.reciipiie_mathongoassignment.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Recipe(
    val id: Long,
    val title: String,
    val servings: Int,
    val pricePerServing: Double,
    val image: String,
    val instructions: String,
    val readyInMinutes: Int,
    @SerializedName("extendedIngredients")
    val ingredients: List<Ingredients>,
    @SerializedName("analyzedInstructions")
    val preparationSteps: List<PreparationSteps>
)
