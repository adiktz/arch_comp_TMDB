package com.showoffs.tmdb.view.viewmodel.moviedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.showoffs.tmdb.domain.moviedetails.MovieDetailsResponse
import com.showoffs.tmdb.repository.moviedetails.MovieDetailsRepo
import com.showoffs.tmdb.repository.utils.Resource

class MovieDetailsViewModel(val id: String) : ViewModel() {
    private val repo = MovieDetailsRepo()
    private var details = MutableLiveData<Resource<MovieDetailsResponse>>()
    init {
        details = repo.getMovieDetails(id) as MutableLiveData<Resource<MovieDetailsResponse>>
    }

    fun getMovieDetails(reload: Boolean = false): LiveData<Resource<MovieDetailsResponse>> {
        if (details.value == null || reload) {
            repo.getMovieDetails(id).observeForever { res ->
                details.value = res
            }
        }
        return details
    }
}
