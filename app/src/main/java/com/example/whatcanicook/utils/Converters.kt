package com.example.whatcanicook.utils

import androidx.room.TypeConverter
import com.example.whatcanicook.data.datamodels.Ingredient
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromIngredients(value: List<Ingredient>): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toIngredients(value: String): List<Ingredient> {
        val listType = object : TypeToken<List<Ingredient>>() {}.type
        return Gson().fromJson(value, listType)
    }

//    @TypeConverter
//    fun fromInstructions(value: List<Instruction>): String {
//        return Gson().toJson(value)
//    }
//
//    @TypeConverter
//    fun toInstructions(value: String): List<Instruction> {
//        val listType = object : TypeToken<List<Instruction>>() {}.type
//        return Gson().fromJson(value, listType)
//    }

}