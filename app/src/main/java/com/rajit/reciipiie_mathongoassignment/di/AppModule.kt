package com.rajit.reciipiie_mathongoassignment.di

import com.rajit.reciipiie_mathongoassignment.repository.LocalRecipeRepository
import com.rajit.reciipiie_mathongoassignment.repository.RecipeRepository
import com.rajit.reciipiie_mathongoassignment.repository.RemoteRecipeRepository
import com.rajit.reciipiie_mathongoassignment.viewmodel.RecipeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<LocalRecipeRepository> { LocalRecipeRepository() }
    single<RemoteRecipeRepository> { RemoteRecipeRepository() }
    single<RecipeRepository> {
        RecipeRepository(
            get<LocalRecipeRepository>(),
            get<RemoteRecipeRepository>()
        )
    }
    viewModel { RecipeViewModel(get<RecipeRepository>()) }
}