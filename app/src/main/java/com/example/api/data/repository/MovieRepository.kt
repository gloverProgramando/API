package com.example.api.data.repository

import com.example.api.data.database.dao.MovieDao
import com.example.api.data.model.MovieType
import com.example.api.data.remote.RemoteDataSource
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val localDataSource: MovieDao,
    private val  remoteDataSource: RemoteDataSource) {

    fun getPopularMovies() = performGetOperation(
        databaseQuery ={localDataSource.getAllMovies(MovieType.POPULAR.value)},
        networkCall = {remoteDataSource.getPopularMovies()},
        saveCalleResult = {localDataSource.insertAll(it.results.toMovieEntityList(MovieType.POPULAR.value))}

    )
}