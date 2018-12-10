package com.curriculumvitae.android.view.viewslice

import android.arch.lifecycle.Lifecycle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.curriculumvitae.android.R
import com.curriculumvitae.android.data.model.TechnicalExperience
import com.curriculumvitae.android.view.adapter.TechnicalExperienceAdapter
import javax.inject.Inject

class TechnicalExperienceViewSlice @Inject constructor(val technicalExperienceAdapter: TechnicalExperienceAdapter) :
    BaseViewSlice() {

    private lateinit var rvTechnicalExperience: RecyclerView
    private lateinit var tvTechnicalExperienceLabel: TextView
    private lateinit var viewTechnicalExperienceSeparator: View

    private lateinit var llmTechnicalExperience: LinearLayoutManager

    override fun init(lifeCycle: Lifecycle, view: View) {
        super.init(lifeCycle, view)
        this.rvTechnicalExperience = view.findViewById(R.id.rv_technical_experience)
        this.tvTechnicalExperienceLabel = view.findViewById(R.id.tv_technical_experience_label)
        this.viewTechnicalExperienceSeparator = view.findViewById(R.id.view_technical_experience_separator)
        this.llmTechnicalExperience = LinearLayoutManager(view.context)
        initViews()
    }

    fun bindTechnicalExperiences(technicalExperienceList: List<TechnicalExperience>) {
        tvTechnicalExperienceLabel.visibility = View.VISIBLE
        viewTechnicalExperienceSeparator.visibility = View.VISIBLE
        technicalExperienceAdapter.data = technicalExperienceList
        technicalExperienceAdapter.notifyDataSetChanged()
    }

    private fun initViews() {
        rvTechnicalExperience.layoutManager = llmTechnicalExperience
        rvTechnicalExperience.adapter = technicalExperienceAdapter
        rvTechnicalExperience.isNestedScrollingEnabled = false
    }

}