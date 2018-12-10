package com.curriculumvitae.android.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.curriculumvitae.android.R
import com.curriculumvitae.android.data.model.EmploymentHistory
import kotterknife.bindView

class EmploymentHistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvRole: TextView by bindView(R.id.tv_role_location_date)
    val tvJobDescription: TextView by bindView(R.id.tv_job_description)

    fun bind(employmentHistory: EmploymentHistory) {
        tvRole.text = itemView.context.getString(
            R.string.curriculum_vitae_job_title,
            employmentHistory.role,
            employmentHistory.company,
            employmentHistory.location,
            employmentHistory.startDate,
            employmentHistory.endDate
        )
        tvJobDescription.text = employmentHistory.description
    }

}