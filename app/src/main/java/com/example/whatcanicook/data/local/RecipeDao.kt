package com.example.whatcanicook.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.whatcanicook.data.datamodels.Recipe

// can ich mit eine DAO BEIDE Entities zugreifen

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: Recipe)

    @Query("SELECT * FROM recipes WHERE id = :recipeId")
    suspend fun getRecipe(recipeId: Int): Recipe?

    @Query("SELECT * FROM recipes ORDER BY title ASC")
    fun getAllRecipes(): LiveData<List<Recipe>>

    @Query("DELETE FROM recipes WHERE id = :recipeId")
    suspend fun deleteRecipe(recipeId: Int)
}
