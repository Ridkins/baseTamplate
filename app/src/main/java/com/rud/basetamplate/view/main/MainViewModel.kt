package com.rud.basetamplate.view.main

import android.arch.lifecycle.MutableLiveData
import com.rud.basetamplate.data.MovieRepository
import com.rud.basetamplate.data.model.Movie
import com.rud.basetamplate.misc.ext.launchAsync
import com.rud.basetamplate.view.AbstractViewModel

class MainViewModel(private val repository: MovieRepository) : AbstractViewModel() {

    val movie = MutableLiveData<List<Movie>>()
    val series = MutableLiveData<List<Movie>>()
    val episode = MutableLiveData<List<Movie>>()

    fun getMovieList(query: String) {
        if (query.isEmpty().not()) {

            //Fun isn't suspended, so it's necessary to run in mainthread
            launchAsync {
                try {
                    //The data is loading
                    setLoading()

                    //Request with a suspended repository funcion
                    val dtoMovies = repository.searchMovies(query)
                    val dtoEpisodes = repository.searchEpisodes(query)
                    val dtoSeries = repository.searchSeries(query)

                    movie.value = dtoMovies.search
                    episode.value = dtoEpisodes.search
                    series.value = dtoSeries.search

                } catch (t: Throwable) {
                    //An error was throw
                    setError(t)
                    movie.value = emptyList()
                } finally {
                    //Isn't loading anymore
                    setLoading(false)
                }
            }

        } else {
            movie.value = emptyList()
        }
    }

    fun start() {
        movie.value = emptyList()
        episode.value = emptyList()
        series.value = emptyList()
    }
}