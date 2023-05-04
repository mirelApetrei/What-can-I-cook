package com.example.whatcanicook.data.datamodels

data class RecipeFilter(
    val query: String,
    val diet: String?,
    val cuisine: String?,
    val intolerances: List<String>,
    val maxReadyTime: Int?

)