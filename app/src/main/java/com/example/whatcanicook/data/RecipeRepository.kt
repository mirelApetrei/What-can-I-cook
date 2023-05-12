package com.example.whatcanicook.data

import com.example.whatcanicook.data.local.RecipeDao
import com.example.whatcanicook.remote.SpoonacularApiService

class RecipeRepository(private val recipeDao: RecipeDao, private val apiService: SpoonacularApiService) {

    suspend fun searchRecipes(query: String, number: Int, cuisine: String?, diet: String?): Resource<List<Recipe>> {
        return try {
            val response = apiService.searchRecipes( query, number, cuisine = cuisine, diet = diet)
            if (response.isSuccessful) {
                val recipes = response.body()?.recipes
                Resource.Success(recipes ?: emptyList())
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }

    suspend fun fetchRecipeDetails(recipeId: Int): Resource<RecipeDetailResponse> {
        return try {
            val response = apiService.getRecipeDetails(recipeId)
            if (response.isSuccessful) {
                val recipeDetails = response.body()
                recipeDetails?.let {
                    recipeDao.insertRecipeDetails(it.toRecipeDetailsEntity())
                }
                Resource.Success(recipeDetails)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Exception) {
            Resource.Error(e.message ?: "An error occurred")
        }
    }

    suspend fun getRecipeDetailsFromDb(recipeId: Int): RecipeDetailResponse? {
        return recipeDao.getRecipeDetails(recipeId)
    }

}
