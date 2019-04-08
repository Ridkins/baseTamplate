package com.rud.basetamplate.data.local

import android.arch.persistence.room.*
import com.rud.basetamplate.data.model.Movie

@Dao
interface MovieDao {

    @Query("SELECT * from movie")
    fun getMovieList(): List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Movie)

    @Update
    fun update(movie: Movie): Int


    @Query("DELETE FROM movie")
    fun deleteAll()
}