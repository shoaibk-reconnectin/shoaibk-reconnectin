package com.sk2apps.moviesassignment.ui.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sk2apps.moviesassignment.R
import com.sk2apps.moviesassignment.model.ResultModel

class MovieAdapter (private val movieList: ArrayList<ResultModel>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>()  {

    fun addItems(mList: List<ResultModel>?) {
        if (mList != null) {
            clearItems()
            movieList.addAll(mList)
            notifyDataSetChanged()
        }
    }

    private fun clearItems() {
        movieList.clear()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.textViewName.text = movie.title
        holder.textViewDescription.text = movie.overview
        holder.textViewDate.text = movie.releaseDate
        Glide.with(holder.itemView.context).load(movie.backdropPath).placeholder(R.mipmap.ic_launcher).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MovieViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: AppCompatImageView = itemView.findViewById(R.id.imageView)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)
    }
}