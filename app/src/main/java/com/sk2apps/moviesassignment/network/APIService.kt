package com.sk2apps.storywall.network

import com.sk2apps.moviesassignment.model.MovieModel
import retrofit2.Call
import retrofit2.http.*

interface APIService {

    @POST("now_playing")
    fun nowPlaying(@Query("api_key") apiKey: String, @Query("language") language: String, @Query("page") page: Int): Call<MovieModel>

}