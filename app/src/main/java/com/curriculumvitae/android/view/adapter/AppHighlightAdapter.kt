package com.curriculumvitae.android.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.curriculumvitae.android.R
import com.curriculumvitae.android.data.model.AppHighlight
import javax.inject.Inject

class AppHighlightAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: List<AppHighlight> = mutableListOf()
        get() = field
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AppHighlightViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_app_highlight,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var appHighlightViewHolder = holder as AppHighlightViewHolder
        appHighlightViewHolder.bind(data.get(position))
    }
}