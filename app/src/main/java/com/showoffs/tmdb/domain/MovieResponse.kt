package com.showoffs.tmdb.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(

        @field:SerializedName("page")
        val page: Int? = null,

        @field:SerializedName("total_pages")
        val totalPages: Int? = null,

        @field:SerializedName("results")
        val results: List<Movie> = arrayListOf(),

        @field:SerializedName("total_results")
        val totalResults: Int? = null
) : Parcelable