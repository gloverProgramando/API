package com.example.api.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GetMoviesResponse(
    @SerializedName("page")
    @Expose
    var page: Int,
    @Expose
    @SerializedName("total_results")
    var totalResults: Int,
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int,
    @SerializedName("results")
    @Expose
    var results: List<Movie>
)