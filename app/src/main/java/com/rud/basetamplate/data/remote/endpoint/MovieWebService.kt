package com.rud.basetamplate.data.remote.endpoint

import com.rud.basetamplate.BuildConfig
import com.rud.basetamplate.data.remote.dto.SearchMovieDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieWebService {

    @GET("?${BuildConfig.API_KEY}")
    fun getMovies(@Query("s") query: String, @Query("type") type: String): Deferred<SearchMovieDto>
}