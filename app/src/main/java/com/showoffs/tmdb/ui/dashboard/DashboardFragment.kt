package com.showoffs.tmdb.ui.dashboard


import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.showoffs.tmdb.R
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.showoffs.tmdb.adapter.dashboard.MoviesAdapter
import com.showoffs.tmdb.common.logTag
import com.showoffs.tmdb.domain.Movie
import com.showoffs.tmdb.repository.utils.Status
import com.showoffs.tmdb.ui.details.MovieDetails
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var layoutManager: GridLayoutManager
    private val adapter by lazy { MoviesAdapter() }
    private var page = 1
    private var totalPages = 1
    private var mIsLoading = true

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        viewModel.getMovies().observe(this, Observer {
            mIsLoading = it.status == Status.LOADING
            if (it.data != null) {
                page = it.data.page ?: 1
                totalPages = it.data.totalPages ?: 1
                Log.d(logTag(), "Page :: $page \t TotalPages :: $totalPages")
            }
        })

        viewModel.getMovieForDisplay().observe(this, Observer { list ->
            list?.takeIf { it.isNotEmpty() }?.apply {
                setAdapterData(this)
            }
        })
    }

    private fun setAdapterData(it: ArrayList<Movie>) {
        adapter.data = it
        Log.d(logTag(), "response is :: $it")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager = if (activity!!.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            GridLayoutManager(context, 3)
        } else {
            GridLayoutManager(context, 5)
        }
        adapter.listener = {
            val intent = Intent(context, MovieDetails::class.java)
            intent.putExtra("movieId", it)
            startActivity(intent)
        }
        movieRecycler.adapter = adapter
        movieRecycler.layoutManager = layoutManager
        movieRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                if (!mIsLoading) {
                    if (visibleItemCount + firstVisibleItemPosition >= totalItemCount && firstVisibleItemPosition >= 0) {
                        if (page < totalPages) {
                            viewModel.getMovieList(hashMapOf("page" to (page + 1).toString()))
                        }
                    }
                }
            }
        })
    }

}
