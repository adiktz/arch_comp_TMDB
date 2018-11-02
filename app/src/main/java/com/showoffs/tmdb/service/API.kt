package com.showoffs.tmdb.service

import android.util.Log
import androidx.lifecycle.LiveData
import com.showoffs.testapplication.util.LiveDataCallAdapterFactory
import com.showoffs.tmdb.BuildConfig
import com.showoffs.tmdb.common.Constants
import com.showoffs.tmdb.repository.utils.ApiResponse
import com.showoffs.tmdb.repository.utils.NetworkBoundResource
import com.showoffs.tmdb.repository.utils.Resource
import com.showoffs.tmdb.service.dashboard.DashboardService
import com.showoffs.tmdb.service.moviedetails.MovieDetailsService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class API {
    private fun client(): OkHttpClient {
        val clientBuilder = OkHttpClient().newBuilder()
                .addNetworkInterceptor {
                    val originalUrl = it.request().url()
                    val url = originalUrl.newBuilder()
                            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
                            .build()
                    val builder = it.request().newBuilder()
                            .url(url)
                    val request = builder.build()
                    return@addNetworkInterceptor it.proceed(request)
                }
        return clientBuilder.build()
    }

    var retrofit: Retrofit = Retrofit.Builder()
            .client(client())
            .baseUrl(Constants.TMDB_API_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()

    companion object {
        private val api = API()
        val dashboardService: DashboardService = api.retrofit.create(DashboardService::class.java)
        val movieDetailService = api.retrofit.create(MovieDetailsService::class.java)

        inline fun <reified RequestType> hitApi(
                hit: LiveData<ApiResponse<RequestType>>
        ): LiveData<Resource<RequestType>> {
            return object : NetworkBoundResource<RequestType>() {
                override fun createCall(): LiveData<ApiResponse<RequestType>> {
                    return hit
                }

                override fun onFetchFailed() {
                    Log.d(API::class.java.simpleName, "Fetching Data Failed")
                }
            }.asLiveData()
        }

    }
}