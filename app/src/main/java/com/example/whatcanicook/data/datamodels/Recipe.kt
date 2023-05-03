package com.example.whatcanicook.data.datamodels

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class Recipe(
    @SerializedName("results")
    val results: List<Result>) {
}