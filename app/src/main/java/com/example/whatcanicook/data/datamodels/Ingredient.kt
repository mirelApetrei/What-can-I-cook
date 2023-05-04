package com.example.whatcanicook.data.datamodels

import com.google.gson.annotations.SerializedName

data class Ingredient(
    @SerializedName("name") val name: String,
    @SerializedName("amount") val amount: Double,
    @SerializedName("unit") val unit: String
)