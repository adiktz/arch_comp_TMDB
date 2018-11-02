package com.showoffs.tmdb.service.moviedetails

import androidx.lifecycle.LiveData
import com.google.gson.JsonObject
import com.showoffs.tmdb.repository.utils.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MovieDetailsService {
    @GET("movie/{movieId}?append_to_response=videos,images")
    fun getMovieDetails(
            @Path("movieId") movieId: String,
            @QueryMap map: HashMap<String, String> = hashMapOf()
    ): LiveData<ApiResponse<JsonObject>>
}