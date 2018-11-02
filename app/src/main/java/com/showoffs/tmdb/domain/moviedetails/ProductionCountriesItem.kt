package com.showoffs.tmdb.domain.moviedetails

import com.google.gson.annotations.SerializedName


data class ProductionCountriesItem(

	@field:SerializedName("iso_3166_1")
	val iso31661: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)