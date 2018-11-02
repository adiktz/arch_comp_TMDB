package com.showoffs.tmdb.common

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity


fun Activity.replace(id: Int, fragment: androidx.fragment.app.Fragment, tag: String = fragment.javaClass.simpleName) {
    (this as AppCompatActivity).supportFragmentManager.beginTransaction().replace(id,
            fragment, tag).commit()
}

fun Fragment.replace(id: Int, fragment: androidx.fragment.app.Fragment, tag: String = fragment.javaClass.simpleName) {
    fragmentManager?.beginTransaction()?.replace(id,
            fragment, tag)?.commit()
}
inline fun <reified T>T.logTag(): String = T::class.java.simpleName
