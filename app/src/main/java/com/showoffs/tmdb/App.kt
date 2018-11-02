package com.showoffs.tmdb

import android.app.Application
import android.content.pm.PackageManager
import android.R.attr.apiKey
import android.os.Bundle
import android.content.pm.ApplicationInfo
import android.util.Log
import com.facebook.drawee.backends.pipeline.Fresco


class App : Application() {

    private val TAG = "MovieDBApplication"

    companion object {
        var apiKey: String = ""
    }

    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}