package com.rajit.reciipiie_mathongoassignment.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajit.reciipiie_mathongoassignment.data.remote.util.NetworkResult
import com.rajit.reciipiie_mathongoassignment.model.Recipes
import com.rajit.reciipiie_mathongoassignment.repository.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class RecipeViewModel(
    private val recipeRepo: RecipeRepository
) : ViewModel() {

    private val _randomRecipes: MutableLiveData<NetworkResult<Recipes>> = MutableLiveData()
    val randomRecipes: LiveData<NetworkResult<Recipes>> = _randomRecipes

    fun getRandomRecipes() = viewModelScope.launch(Dispatchers.IO) {
        val recipesResponse = recipeRepo.remoteRepository.getRandomRecipes()

        withContext(Dispatchers.Main) {
            try {
                _randomRecipes.value = handleRecipesResponse(recipesResponse)
            } catch (e: Exception) {
                _randomRecipes.value = NetworkResult.Error(e.message)
            }
        }
    }

    private fun handleRecipesResponse(
        response: Response<Recipes>
    ): NetworkResult<Recipes> {
        return when {
            response.message().contains("timeout") -> {
                NetworkResult.Error("Timeout Error")
            }

            response.isSuccessful -> {
                val randomRecipe = response.body()
                NetworkResult.Success(randomRecipe!!)
            }

            else -> NetworkResult.Loading()
        }
    }

    fun isALlOk() {
        Log.i("AppCheck", "DI & ViewModel Check: OK")
        checkRecipeRepo()
    }

    private fun checkRecipeRepo() {
        recipeRepo.localRepository.isAllOk()
        recipeRepo.remoteRepository.isAllOk()
    }

}