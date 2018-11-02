package com.showoffs.tmdb.repository.dashboard

import androidx.lifecycle.LiveData
import com.showoffs.tmdb.domain.MovieResponse
import com.showoffs.tmdb.repository.utils.Resource
import com.showoffs.tmdb.service.API

class DashboardRepo {
    private val dashboardService = API.dashboardService

    fun getMoviesList(
            map: HashMap<String, String> = hashMapOf()
    ): LiveData<Resource<MovieResponse>> {
        return API.hitApi(dashboardService.getList(map))
    }

}