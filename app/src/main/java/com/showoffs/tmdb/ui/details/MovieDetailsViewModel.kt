package com.showoffs.tmdb.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.facebook.soloader.SoLoader.init
import com.google.gson.JsonObject
import com.showoffs.tmdb.repository.moviedetails.MovieDetailsRepo
import com.showoffs.tmdb.repository.utils.Resource

class MovieDetailsViewModel(val id: String) : ViewModel() {
    private val repo = MovieDetailsRepo()
    private var details = MutableLiveData<Resource<JsonObject>>()
    init {
        details = repo.getMovieDetails(id) as MutableLiveData<Resource<JsonObject>>
    }

    fun getMovieDetails(reload: Boolean = false): LiveData<Resource<JsonObject>> {
        if (details.value == null || reload) {
            repo.getMovieDetails(id).observeForever { res ->
                details.value = res
            }
        }
        return details
    }
}
