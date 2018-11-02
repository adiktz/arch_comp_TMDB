package com.showoffs.tmdb.ui.details

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.showoffs.tmdb.R
import com.showoffs.tmdb.common.logTag
import kotlinx.android.synthetic.main.movie_details_fragment.*

class MovieDetailsFragment : Fragment() {
    init {
        arguments = Bundle()
    }

    private lateinit var viewModel: MovieDetailsViewModel
    private lateinit var factory: MovieDetailsViewModeFactory

    private val movieId: String? by lazy {
        arguments!!["movieId"] as? String ?: activity?.intent?.getStringExtra("movieId")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.movie_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        factory = MovieDetailsViewModeFactory(movieId!!)
        viewModel = ViewModelProviders.of(this, factory).get(MovieDetailsViewModel::class.java)
        viewModel.getMovieDetails().observe(this, Observer {
            data.text = it.data?.toString()
            Log.d(logTag(), "result :: ${it.data}")
        })
    }

}
