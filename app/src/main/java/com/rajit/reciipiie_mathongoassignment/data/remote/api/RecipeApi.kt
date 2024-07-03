package com.rajit.reciipiie_mathongoassignment.data.remote.api

import com.rajit.reciipiie_mathongoassignment.model.Recipes
import com.rajit.reciipiie_mathongoassignment.util.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApi {

    @GET("/recipes/random")
    suspend fun getRandomRecipes(
        @Query("number")
        numberOfRecipes: Int = 6,
        @Query("includeNutrition")
        includeNutrition: Boolean = true,
        @Query("apiKey")
        apiKey: String = AppConstants.apiKey
    ): Response<Recipes>

}