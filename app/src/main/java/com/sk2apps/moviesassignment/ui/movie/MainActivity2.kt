package com.sk2apps.moviesassignment.ui.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cheezycode.randomquote.db.MovieDao
import com.cheezycode.randomquote.db.MovieDatabase
import com.sk2apps.moviesassignment.AppUtils
import com.sk2apps.moviesassignment.R
import com.sk2apps.moviesassignment.databinding.ActivityMain2Binding
import com.sk2apps.moviesassignment.viewmodel.MovieViewModel
import com.sk2apps.moviesassignment.factory.MovieViewModelFactory
import com.sk2apps.moviesassignment.model.ResultModel
import com.sk2apps.moviesassignment.repository.MainRepository
import com.sk2apps.storywall.network.RetrofitClient

class MainActivity2 : AppCompatActivity() {

    lateinit var movieViewModel: MovieViewModel

    private val TAG = MainActivity2::class.java.simpleName
    private lateinit var binding: ActivityMain2Binding

    private lateinit var movieDao: MovieDao

    private val apiService = RetrofitClient.getApi()

    private val adapter: MovieAdapter = MovieAdapter(ArrayList<ResultModel>())
    private var movieList = ArrayList<ResultModel>()

    private var page: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        movieDao = MovieDatabase.getDatabase(applicationContext).dao()
        movieViewModel = ViewModelProvider(
            this,
            MovieViewModelFactory(MainRepository(apiService), movieDao, applicationContext)
        ).get(MovieViewModel::class.java)

        //val recyclerview = findViewById<RecyclerView>(R.id.recyclerViewMovie)
        setUpRecyclerView()

        movieViewModel.movieList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            movieList.addAll(it)
            adapter.addItems(movieList)
        })

        movieViewModel.errorMessage.observe(this, Observer {

        })

        movieViewModel.nowPlaying("d1073ccb353611a1169e799b334a631e", "en-US", page)

    }

    private fun setUpRecyclerView() {
        binding.recyclerViewMovie.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMovie.itemAnimator = DefaultItemAnimator()
        binding.recyclerViewMovie.adapter = adapter

        binding.recyclerViewMovie.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (AppUtils.isNetworkConnected(this@MainActivity2)) {
                    page = page + 1
                    if (!recyclerView.canScrollVertically(1)) {
                        movieViewModel.nowPlaying("d1073ccb353611a1169e799b334a631e", "en-US", page)

                    }
                }
            }

        })
    }
}