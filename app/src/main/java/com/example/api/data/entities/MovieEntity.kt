package com.example.api.data.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movieEntity")
data class MovieEntity(
    @PrimaryKey
    val id: Int = 0,
    @ColumnInfo("adult")
    val adult: Boolean = false,
    @ColumnInfo("genre_ids")
    var genres: List<Long> = ArrayList(),
    @ColumnInfo("backdrop_path")
    var backdropPath: String? = "",
    @ColumnInfo("original_title")
    var originTitle: String? = "",
    @ColumnInfo("original_language")
    var originalLanguage: String? = "",
    @ColumnInfo("overview")
    var overview: String? = "",
    @ColumnInfo("popularity")
    var popularity: Float? = 0f,
    @ColumnInfo("poster_path")
    var posterPath: String? = "",
    @ColumnInfo("release_date")
    var releaseDate: String,
    @ColumnInfo("title")
    var title: String? = "",
    @ColumnInfo("video")
    var video: Boolean? = false,
    @ColumnInfo("vote_average")
    var voteAverage: Float? = 0f,
    @ColumnInfo("vote_count")
    var voteCount: Int? = 0,
    @ColumnInfo("movie_type")
    var movieType: Int = 0
):Parcelable
