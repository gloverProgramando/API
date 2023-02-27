package com.example.api.ui.popular

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.api.R
import com.example.api.data.entities.MovieEntity
import com.example.api.data.repository.MovieRepository
import com.example.api.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor( repository: MovieRepository) : ViewModel() {

    val fetchPopularmovies: LiveData<Resource<List<MovieEntity>>> = repository.getPopularMovies()
}