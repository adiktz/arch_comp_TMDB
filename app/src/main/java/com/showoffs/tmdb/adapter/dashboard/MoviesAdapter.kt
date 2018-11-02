package com.showoffs.tmdb.adapter.dashboard

import com.showoffs.tmdb.R
import com.showoffs.tmdb.adapter.BaseAdapter
import com.showoffs.tmdb.adapter.ViewHolder
import com.showoffs.tmdb.domain.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MoviesAdapter: BaseAdapter<Movie>(R.layout.movie_item) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.imageView.setImageURI("http://image.tmdb.org/t/p/w342${data[position].posterPath}")
    }
}