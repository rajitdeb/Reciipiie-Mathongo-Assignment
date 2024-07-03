package com.rajit.reciipiie_mathongoassignment.model

import kotlinx.serialization.Serializable

@Serializable
data class Equipment(
    val id: Long,
    val image: String,
    val name: String
)
