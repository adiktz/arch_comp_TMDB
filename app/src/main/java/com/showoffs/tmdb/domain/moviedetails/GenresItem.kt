package com.showoffs.tmdb.domain.moviedetails


import com.google.gson.annotations.SerializedName


data class GenresItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)