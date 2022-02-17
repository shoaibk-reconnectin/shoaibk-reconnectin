package com.cheezycode.randomquote.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sk2apps.moviesassignment.model.ResultModel

@Dao
interface MovieDao {

    @Insert
    suspend fun addMovieList(movie: List<ResultModel>)

    @Query("SELECT * FROM movie_list")
    suspend fun getMovieList() : List<ResultModel>

    @Query("DELETE FROM movie_list")
    suspend fun deleteAllMovieList()
}