package com.example.api.data.remote

import com.example.api.utils.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) :BaseDataSource(){
    suspend fun getPopularMovies() = getResult{ apiService.getPopularMovie(Const.API_KEY)}
}