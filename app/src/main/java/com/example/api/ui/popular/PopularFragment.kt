package com.example.api.ui.popular

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api.R
import com.example.api.data.entities.MovieEntity
import com.example.api.databinding.FragmentPopularBinding


private var _binding: FragmentPopularBinding? = null

private val binding get() = _binding!!

private val viewModel: PopularViewModel by navGraphViewModels(R.id.nav_graph) {
    defaultViewModelProviderFactory
    override fun  onViewCreate(view: View,savedInstantState: Bundle?){
        val onViewCreate = super.onViewCreate(view, savedInstantState)
        binding.rvMovies.layoutManager = LinearLayoutManager(context)

    }


    override fun  onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    override fun onMovieClick(movieEntity: MovieEntity){
        val action = PopularFragmentDirections.actionHomeFragmentToDetailsFragment(movieEntity)
        findNavController.navigate(action)
    }
}
