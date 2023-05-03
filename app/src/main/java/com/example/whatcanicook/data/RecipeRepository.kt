package com.example.whatcanicook.data

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.whatcanicook.data.datamodels.Recipe
import com.example.whatcanicook.data.local.RecipesDatabase
import com.example.whatcanicook.remote.RecipeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class RecipeRepository(private val api: RecipeApi, private val database: RecipesDatabase) {

    val recipesList: LiveData<List<Recipe>> = database.recipesDatabaseDao.getAll()




    suspend fun getRecipes(queries: Map<String, String>) {
        withContext(Dispatchers.IO){
            val newRecipesList = api.retrofitService.getRecipes(queries)
            database.recipesDatabaseDao.insertAll(newRecipesList)
        }
    }
}