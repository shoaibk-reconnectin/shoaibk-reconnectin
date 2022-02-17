package com.sk2apps.moviesassignment.repository

import com.sk2apps.storywall.network.APIService

class MainRepository constructor(private val apiService: APIService) {

    fun nowPlaying(apiKey: String, language: String, page: Int) = apiService.nowPlaying(apiKey, language, page)
}