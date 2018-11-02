package com.showoffs.tmdb.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.showoffs.tmdb.domain.Movie
import com.showoffs.tmdb.repository.dashboard.DashboardRepo
import com.showoffs.tmdb.domain.MovieResponse
import com.showoffs.tmdb.repository.utils.Resource


class DashboardViewModel : ViewModel() {
    private var movie: LiveData<ArrayList<Movie>> = MutableLiveData<ArrayList<Movie>>()
    private val movieResponse = MutableLiveData<Resource<MovieResponse>>()
    private val dashboardRepo = DashboardRepo()

    init {
        getMovieList()
        movie = Transformations.switchMap<Resource<MovieResponse>, ArrayList<Movie>>(
                movieResponse
        ) { input ->
            input?.data?.page?.let { p ->
                return@switchMap if (p == 1) {
                    val o = MutableLiveData<ArrayList<Movie>>()
                    o.value = input.data.results as ArrayList<Movie>
                    o
                } else {
                    val o = MutableLiveData<ArrayList<Movie>>()
                    val a = movie.value
                    a?.addAll(input.data.results)
                    o.value = a
                    o
                }
            }
        }
    }

    fun getMovieList(map: HashMap<String, String> = hashMapOf()) {
        dashboardRepo.getMoviesList(map).observeForever { movieResource ->
            movieResponse.value = movieResource
        }

    }

    fun getMovies(): LiveData<Resource<MovieResponse>> {
        return movieResponse
    }

    fun getMovieForDisplay() = movie

}