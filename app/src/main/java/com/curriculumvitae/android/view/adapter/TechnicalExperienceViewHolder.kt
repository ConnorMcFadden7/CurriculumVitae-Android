package com.curriculumvitae.android.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.curriculumvitae.android.R
import com.curriculumvitae.android.data.model.TechnicalExperience
import kotterknife.bindView

class TechnicalExperienceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvTitle: TextView by bindView(R.id.tv_title)
    val tvSkills: TextView by bindView(R.id.tv_skills)

    fun bind(technicalExperience: TechnicalExperience) {
        tvTitle.text = technicalExperience.title
        tvSkills.text = technicalExperience.skills
    }

}