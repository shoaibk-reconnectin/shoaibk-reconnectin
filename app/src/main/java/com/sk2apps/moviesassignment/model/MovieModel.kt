package com.sk2apps.moviesassignment.model


import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("dates")
    var dates: Dates?,
    @SerializedName("page")
    var page: Int?,
    @SerializedName("results")
    var resultModels: List<ResultModel>?,
    @SerializedName("total_pages")
    var totalPages: Int?,
    @SerializedName("total_results")
    var totalResults: Int?
)