package com.example.whatcanicook.remote

import com.example.whatcanicook.data.datamodels.RecipeDetailResponse
import com.example.whatcanicook.data.datamodels.RecipeSearchResponse
import com.example.whatcanicook.utils.Constants.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit =
    Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

interface SpoonacularApiService {
    @GET("recipes/complexSearch")
    suspend fun searchRecipes(
        @Query("query") query: String,
        @Query("number") number: Int = 20,
        @Query("offset") offset: Int = 0,
        @Query("sort") sort: String? = null,
        @Query("sortDirection") sortDirection: String? = null,
        @Query("cuisine") cuisine: String? = null,
        @Query("diet") diet: String? = null,
        @Query("intolerances") intolerances: String? = null,
        @Query("type") type: String? = null,
        @Query("instructionsRequired") instructionsRequired: Boolean? = null,
        @Query("addRecipeInformation") addRecipeInformation: Boolean? = null,
        @Query("fillIngredients") fillIngredients: Boolean? = null
    ): Response<RecipeSearchResponse>


    @GET("recipes/{id}/information")
    suspend fun getRecipeDetails(
        @Path("id") id: Int,
        @Query("includeNutrition") includeNutrition: Boolean? = null
    ): Response<RecipeDetailResponse>


}

object RecipeApi {
    val spoonacularService: SpoonacularApiService by lazy { retrofit.create(SpoonacularApiService::class.java) }
}
