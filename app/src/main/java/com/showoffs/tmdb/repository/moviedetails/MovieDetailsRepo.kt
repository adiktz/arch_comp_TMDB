package com.showoffs.tmdb.repository.moviedetails

import com.showoffs.tmdb.service.API

class MovieDetailsRepo {

    private val service = API.movieDetailService

    fun getMovieDetails(movieId: String) = API.hitApi(service.getMovieDetails(movieId))

}