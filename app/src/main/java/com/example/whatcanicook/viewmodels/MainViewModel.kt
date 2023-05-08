package com.example.whatcanicook.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatcanicook.data.RecipeRepository
import com.example.whatcanicook.data.local.getDatabase
import com.example.whatcanicook.network.RecipeApi
import kotlinx.coroutines.launch

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

       }
    }

}


