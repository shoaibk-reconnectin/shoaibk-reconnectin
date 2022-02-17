package com.sk2apps.moviesassignment.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheezycode.randomquote.db.MovieDao
import com.sk2apps.moviesassignment.AppUtils
import com.sk2apps.moviesassignment.model.MovieModel
import com.sk2apps.moviesassignment.model.ResultModel
import com.sk2apps.moviesassignment.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel(private val repository: MainRepository, private val dao: MovieDao, private val context: Context): ViewModel() {

    val movieList = MutableLiveData<List<ResultModel>>()
    val errorMessage = MutableLiveData<String>()

    fun nowPlaying(apiKey: String, language: String, page: Int) {
        if (AppUtils.isNetworkConnected(context)) {
            var response = repository.nowPlaying(apiKey, language, page)
            response.enqueue(object : Callback<MovieModel> {
                override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
                    if (response.body() != null) {
                        viewModelScope.launch(Dispatchers.IO) {
                            dao.deleteAllMovieList()
                            dao.addMovieList(response.body()!!.resultModels!!)
                        }
                        movieList.postValue(response.body()!!.resultModels!!)
                    } else {
                        viewModelScope.launch(Dispatchers.IO) {
                            movieList.postValue(dao.getMovieList())
                        }
                    }
                }

                override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                    errorMessage.postValue(t.message)
                }
            })
        }else {
            viewModelScope.launch(Dispatchers.IO) {
                movieList.postValue(dao.getMovieList())
            }
            Toast.makeText(context, "No Internet Connection!", Toast.LENGTH_SHORT).show()
        }

    }
}