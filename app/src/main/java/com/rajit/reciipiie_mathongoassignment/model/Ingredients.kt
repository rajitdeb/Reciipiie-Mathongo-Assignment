package com.rajit.reciipiie_mathongoassignment.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Ingredients(
    val name: String,
    @SerializedName("image")
    val imgLink: String
)
