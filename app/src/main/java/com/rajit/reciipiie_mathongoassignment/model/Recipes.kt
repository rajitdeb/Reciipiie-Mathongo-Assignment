package com.rajit.reciipiie_mathongoassignment.model

import com.google.gson.annotations.SerializedName

data class Recipes(
    @SerializedName("recipes")
    val recipeList: List<Recipe>
)
