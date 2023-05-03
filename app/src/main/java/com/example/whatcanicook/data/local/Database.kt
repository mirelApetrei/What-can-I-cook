package com.example.whatcanicook.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.whatcanicook.data.datamodels.Recipe

//@Database(entities = [Recipe::class], entities = [ShoppingList::class]...version = 1)
@Database(entities = [Recipe::class], version = 1)
abstract class RecipesDatabase : RoomDatabase() {

    abstract  val recipesDatabaseDao: RecipesDatabaseDAO
}

private lateinit var INSTANCE: RecipesDatabase

fun getDatabase(context: Context): RecipesDatabase {
    synchronized(RecipesDatabase::class.java){
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                RecipesDatabase::class.java,
                "recipes_database"
            ).build()
        }
    }
    return INSTANCE
}
