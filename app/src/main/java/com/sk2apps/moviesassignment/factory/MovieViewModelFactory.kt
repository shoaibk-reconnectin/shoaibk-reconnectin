package com.sk2apps.moviesassignment.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cheezycode.randomquote.db.MovieDao
import com.sk2apps.moviesassignment.repository.MainRepository
import com.sk2apps.moviesassignment.viewmodel.MovieViewModel

class MovieViewModelFactory constructor(private val repository: MainRepository, private val dao: MovieDao, private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
            MovieViewModel(this.repository, dao, context) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}