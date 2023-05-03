package com.example.whatcanicook.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatcanicook.data.RecipeRepository
import com.example.whatcanicook.data.local.getDatabase
import com.example.whatcanicook.remote.RecipeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.http.Query
import retrofit2.http.QueryMap

const val TAG = "MainViewModel"

class MainViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repository = RecipeRepository(RecipeApi, database)

    val recipes = repository.recipesList

    init {
        loadData()
    }

     private fun loadData() {
       viewModelScope.launch {
           try {
               repository.getRecipes()
           }
       }
    }

}


