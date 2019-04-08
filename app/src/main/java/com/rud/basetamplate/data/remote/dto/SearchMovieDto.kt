package com.rud.basetamplate.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.rud.basetamplate.data.model.Movie

class SearchMovieDto : Dto() {
    @SerializedName("Search")
    var search: List<Movie>? = null
}