package com.example.whatcanicook.models

import com.example.whatcanicook.Result
import com.google.gson.annotations.SerializedName

data class FoodRecipe(
    @SerializedName("results")
    val results: List<Result>
)