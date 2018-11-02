package com.showoffs.tmdb.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BaseAdapter<D>(val layout: Int): androidx.recyclerview.widget.RecyclerView.Adapter<ViewHolder>() {

    var data: ArrayList<D> = arrayListOf()
    set(value) {
        field.clear()
        field.addAll(value)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context)
                    .inflate(layout, parent, false))

    override fun getItemCount(): Int  = data.size

}