package com.rajit.reciipiie_mathongoassignment.di

import com.rajit.reciipiie_mathongoassignment.data.remote.api.RecipeApi
import com.rajit.reciipiie_mathongoassignment.repository.LocalRecipeRepository
import com.rajit.reciipiie_mathongoassignment.repository.RecipeRepository
import com.rajit.reciipiie_mathongoassignment.repository.RemoteRecipeRepository
import com.rajit.reciipiie_mathongoassignment.util.AppConstants
import com.rajit.reciipiie_mathongoassignment.viewmodel.RecipeViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BASIC)
        }
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    single<GsonConverterFactory> {
        GsonConverterFactory.create()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(get<OkHttpClient>())
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }

    single<RecipeApi> { get<Retrofit>().create(RecipeApi::class.java) }

    single<LocalRecipeRepository> { LocalRecipeRepository() }
    single<RemoteRecipeRepository> { RemoteRecipeRepository(get<RecipeApi>()) }
    single<RecipeRepository> {
        RecipeRepository(
            get<LocalRecipeRepository>(),
            get<RemoteRecipeRepository>()
        )
    }

    viewModel { RecipeViewModel(get<RecipeRepository>()) }
}