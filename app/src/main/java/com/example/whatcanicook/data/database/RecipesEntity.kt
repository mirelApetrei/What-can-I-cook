package com.example.whatcanicook.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.whatcanicook.models.FoodRecipe

import com.example.whatcanicook.utils.Constants.Companion.RECIPES_TABLE


@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}