package com.curriculumvitae.android.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.curriculumvitae.android.R
import com.curriculumvitae.android.data.model.Education
import javax.inject.Inject

class EducationAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: List<Education> = mutableListOf()
        get() = field
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EducationViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_education, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val educationViewHolder = holder as EducationViewHolder
        educationViewHolder.bind(data.get(position))
    }

}