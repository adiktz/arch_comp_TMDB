package com.showoffs.tmdb.domain.moviedetails

import com.google.gson.annotations.SerializedName


data class Videos(

	@field:SerializedName("results")
	val results: List<ResultsItem>? = null
)