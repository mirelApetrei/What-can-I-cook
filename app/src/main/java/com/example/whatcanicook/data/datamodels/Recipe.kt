package com.example.whatcanicook.data.datamodels

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "recipes")
data class Recipe(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("image") val imageUrl: String,
    @SerializedName("missedIngredientCount") val missedIngredientCount: Int,
    @SerializedName("missedIngredients") val missedIngredients: List<Ingredient>,
    @SerializedName("usedIngredients") val usedIngredients: List<Ingredient>,
    @SerializedName("unusedIngredients") val unusedIngredients: List<Ingredient>,
)