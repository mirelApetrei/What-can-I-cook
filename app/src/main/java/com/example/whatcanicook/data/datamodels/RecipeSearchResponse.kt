package com.example.whatcanicook.data.datamodels

import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(
    @SerializedName("results") val recipes: List<Recipe>,
    @SerializedName("totalResults") val totalResults: Int
) {
}