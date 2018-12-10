package com.curriculumvitae.android.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.curriculumvitae.android.R
import com.curriculumvitae.android.data.model.Education
import kotterknife.bindView

class EducationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvEducationLabel: TextView by bindView(R.id.tv_location_date_label)
    val tvGrades: TextView by bindView(R.id.tv_grades)

    fun bind(education: Education) {
        tvEducationLabel.text = itemView.context.getString(
            R.string.curriculum_vitae_education_title,
            education.location,
            education.startDate,
            education.endDate
        )
        tvGrades.text = education.grades
    }

}