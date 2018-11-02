package com.showoffs.tmdb.service

import androidx.lifecycle.LiveData
import com.showoffs.tmdb.domain.MovieResponse
import com.showoffs.tmdb.repository.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface DashboardService {
    @GET("discover/movie")
    fun getList(@QueryMap map: HashMap<String, String> = hashMapOf()): LiveData<ApiResponse<MovieResponse>>
}