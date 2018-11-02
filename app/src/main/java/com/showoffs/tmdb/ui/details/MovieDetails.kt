package com.showoffs.tmdb.ui.details

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.showoffs.tmdb.R
import com.showoffs.tmdb.common.replace

import kotlinx.android.synthetic.main.activity_details.*

class MovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setSupportActionBar(toolbar)
        if (savedInstanceState == null) {
            replace(R.id.container, MovieDetailsFragment())
        }
    }

}
