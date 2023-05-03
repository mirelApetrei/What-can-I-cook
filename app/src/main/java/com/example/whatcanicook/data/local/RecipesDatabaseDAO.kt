package com.example.whatcanicook.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.whatcanicook.data.datamodels.Recipe
import retrofit2.Response

// can ich mit eine DAO BEIDE Entities zugreifen

@Dao
interface RecipesDatabaseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(recipes: Response<Recipe>)

    @Query("SELECT * FROM Recipe")
    fun getAll(): LiveData<List<Recipe>>

    @Query("DELETE FROM Recipe")
    fun deleteAll()
}