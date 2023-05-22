package com.example.whatcanicook.data.network



import com.example.whatcanicook.models.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoodRecipesApi {

    // This function gets recipes from the server.
    @GET("/recipes/complexSearch")
    suspend fun getRecipes(
        @QueryMap queries: Map<String, String>    //  queries A map of query parameters to send to the server
    ): Response<FoodRecipe>                      // @return A `Response` object containing the recipes from the server.



    // This function searches for recipes from the server.
    @GET("/recipes/complexSearch")
    suspend fun searchRecipes(
        @QueryMap searchQuery: Map<String, String>      // @param searchQuery A map of query parameters to send to the server.
    ): Response<FoodRecipe>                             // @return A `Response` object containing the recipes from the server.

}