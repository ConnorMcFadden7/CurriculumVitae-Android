package com.curriculumvitae.android.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.curriculumvitae.android.R
import com.curriculumvitae.android.data.model.TechnicalExperience
import javax.inject.Inject

class TechnicalExperienceAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: List<TechnicalExperience> = mutableListOf()
        get() = field
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TechnicalExperienceViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_technical_experience,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val technicalExperienceViewHolder = holder as TechnicalExperienceViewHolder
        technicalExperienceViewHolder.bind(data.get(position))
    }

}