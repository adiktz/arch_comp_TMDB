package com.showoffs.tmdb.repository

import androidx.lifecycle.LiveData
import com.showoffs.tmdb.domain.MovieResponse
import com.showoffs.tmdb.service.API

class DashboardRepo {
    private val dashboardService = API.dashboardService

    fun getMoviesList(
            map: HashMap<String, String> = hashMapOf()
    ): LiveData<Resource<MovieResponse>> {
        return API.hitApi(dashboardService.getList(map))
    }

}