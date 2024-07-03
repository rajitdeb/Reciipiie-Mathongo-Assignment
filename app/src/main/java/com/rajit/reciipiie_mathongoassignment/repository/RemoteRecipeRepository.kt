package com.rajit.reciipiie_mathongoassignment.repository

import android.util.Log
import com.rajit.reciipiie_mathongoassignment.data.remote.api.RecipeApi
import com.rajit.reciipiie_mathongoassignment.model.Recipes
import retrofit2.Response

class RemoteRecipeRepository(
    private val recipeApi: RecipeApi
) {

    suspend fun getRandomRecipes(): Response<Recipes> {
        return recipeApi.getRandomRecipes()
    }

    fun isAllOk() {
        Log.i("AppCheck", "Remote Recipe Repository Check: OK")
    }

}