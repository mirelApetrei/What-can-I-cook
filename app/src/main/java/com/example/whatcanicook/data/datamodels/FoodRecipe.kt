package com.example.whatcanicook.data.datamodels

import com.google.gson.annotations.SerializedName


data class FoodRecipe(
    @SerializedName("results")
    val results: List<Result>
)