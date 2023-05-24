package com.example.whatcanicook.data.database

import androidx.room.TypeConverter
import com.example.whatcanicook.models.FoodRecipe
import com.example.whatcanicook.models.Result


import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecipesTypeConverter {

    var gson = Gson() //<-- because we want to serialize

    @TypeConverter
    fun foodRecipeToString(foodRecipe: FoodRecipe): String {
        return gson.toJson(foodRecipe)
    }

    @TypeConverter
    fun stringToFoodRecipe(data: String): FoodRecipe {
        val listType = object : TypeToken<FoodRecipe>() {}.type
        return gson.fromJson(data, listType)
    }

//    the next 2 functions are for converting Result to Json, for favorites recipes
    @TypeConverter
    fun resultToString(result: Result): String {
        return gson.toJson(result)
    }

    @TypeConverter
    fun stringToResult(data: String): Result {
        val listType = object : TypeToken<Result>() {}.type
        return gson.fromJson(data, listType)
    }


}
/*we convert the Json object to a string, and vice-versa, to store in our database*/