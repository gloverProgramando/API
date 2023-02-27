package com.example.api.data.model

import android.os.Parcelable
import com.example.api.data.entities.MovieEntity
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Movie(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("genre_ids")
    val genres: List<Long> = ArrayList(),
    @SerializedName("backdrop_path")
    val backdropPath: String? = "",
    @SerializedName("original_title")
    val originTitle: String? = "",
    @SerializedName("original_language")
    val originalLanguage: String? = "",
    @SerializedName("overview")
    val overview: String? = "",
    @SerializedName("popularity")
    val popularity: Float? = 0f,
    @SerializedName("poster_path")
    val posterPath: String? = "",
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("video")
    val video: Boolean? = false,
    @SerializedName("vote_average")
    val voteAverage: Float? = 0f,
    @SerializedName("vote_count")
    val voteCount: Int? = 0,

) : Parcelable

fun Movie.toMovieEntity(movieType: Int): MovieEntity = MovieEntity(
    id = this.id,
    adult = this.adult,
    backdropPath = this.backdropPath,
    originTitle = this.originTitle,
    originalLanguage = this.originalLanguage,
    overview = this.overview,
    popularity = this.popularity,
    posterPath = this.posterPath,
    releaseDate = this.releaseDate,
    title = this.title,
    video = this.video,
    voteAverage = this.voteAverage,
    voteCount = this.voteCount,
    movieType = movieType
)

fun List<Movie>.toMovieEntityList(movieType: Int): List<MovieEntity> {
    val  resultList = mutableListOf<MovieEntity>()
    this.forEach {movies ->
        resultList.add(movies.toMovieEntity(movieType))

    }
    return resultList
}