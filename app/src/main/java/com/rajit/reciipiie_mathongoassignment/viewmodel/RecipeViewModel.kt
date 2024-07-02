package com.rajit.reciipiie_mathongoassignment.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.rajit.reciipiie_mathongoassignment.repository.RecipeRepository

class RecipeViewModel(
    private val recipeRepo: RecipeRepository
): ViewModel() {

    fun isALlOk() {
        Log.i("AppCheck", "DI & ViewModel Check: OK")
        checkRecipeRepo()
    }

    private fun checkRecipeRepo() {
        recipeRepo.localRepository.isAllOk()
        recipeRepo.remoteRepository.isAllOk()
    }

}