package com.example.api.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.api.data.entities.MovieEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM movieEntity WHERE movie_type = :movieType")
    fun getAllMovies(movieType: Int): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movieEntity: MovieEntity)
}