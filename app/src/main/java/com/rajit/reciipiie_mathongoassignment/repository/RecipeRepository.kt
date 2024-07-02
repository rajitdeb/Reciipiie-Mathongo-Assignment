package com.rajit.reciipiie_mathongoassignment.repository

class RecipeRepository(
    val localRepository: LocalRecipeRepository,
    val remoteRepository: RemoteRecipeRepository
)