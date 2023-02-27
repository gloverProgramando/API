package com.example.api.data.remote

import com.example.api.data.model.GetMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.nio.channels.spi.AbstractSelectionKey

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovie(@Query("") apiKey: String): Response<GetMoviesResponse>
}