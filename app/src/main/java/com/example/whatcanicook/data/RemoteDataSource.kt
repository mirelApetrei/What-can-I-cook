package com.example.whatcanicook.data


import com.example.whatcanicook.data.network.FoodRecipesApi
import com.example.whatcanicook.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

// This class is a remote data source for food recipes.
class RemoteDataSource @Inject constructor(
    private val foodRecipesApi: FoodRecipesApi          //<--  The `foodRecipesApi` property is an `Api` object that provides access to the food recipes API.
) {

    // This suspend function gets recipes from the server
    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return foodRecipesApi.getRecipes(queries)
    }


    // This suspend function searches for recipes from the server.
    suspend fun searchRecipes(searchQuery: Map<String, String>): Response<FoodRecipe> {
        return foodRecipesApi.searchRecipes(searchQuery)
    }
}