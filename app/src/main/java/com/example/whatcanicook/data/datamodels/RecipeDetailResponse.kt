package com.example.whatcanicook.data.datamodels

import com.google.gson.annotations.SerializedName

data class RecipeDetailResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("image")
    val imageUrl: String?,
    @SerializedName("readyInMinutes")
    val readyInMinutes: Int,
    @SerializedName("servings")
    val servings: Int,
    @SerializedName("sourceUrl")
    val sourceUrl: String,
    @SerializedName("extendedIngredients")
    val ingredients: List<Ingredient>,
    @SerializedName("instructions")
    val instructions: String?
)