package com.example.whatcanicook.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.whatcanicook.models.Result
import com.example.whatcanicook.utils.Constants.Companion.FAVORITE_RECIPES_TABLE


@Entity(tableName = FAVORITE_RECIPES_TABLE)
class FavoritesEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: Result
)