package com.rajit.reciipiie_mathongoassignment.model

import kotlinx.serialization.Serializable

@Serializable
data class PreparationSteps(
    val steps: List<IndividualSteps>
)
