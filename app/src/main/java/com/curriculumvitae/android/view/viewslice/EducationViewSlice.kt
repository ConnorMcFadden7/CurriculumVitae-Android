package com.curriculumvitae.android.view.viewslice

import android.arch.lifecycle.Lifecycle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.curriculumvitae.android.R
import com.curriculumvitae.android.data.model.Education
import com.curriculumvitae.android.view.adapter.EducationAdapter
import javax.inject.Inject

class EducationViewSlice @Inject constructor(val educationAdapter: EducationAdapter) : BaseViewSlice() {

    private lateinit var rvEducation: RecyclerView
    private lateinit var tvEducationLabel: TextView
    private lateinit var viewEducationSeparator: View

    private lateinit var llmEducation: LinearLayoutManager

    override fun init(lifeCycle: Lifecycle, view: View) {
        super.init(lifeCycle, view)
        this.rvEducation = view.findViewById(R.id.rv_education)
        this.tvEducationLabel = view.findViewById(R.id.tv_education_label)
        this.viewEducationSeparator = view.findViewById(R.id.view_education_separator)
        this.llmEducation = LinearLayoutManager(view.context)
        initViews()
    }

    fun bindEducation(educationList: List<Education>) {
        tvEducationLabel.visibility = View.VISIBLE
        viewEducationSeparator.visibility = View.VISIBLE
        educationAdapter.data = educationList
        educationAdapter.notifyDataSetChanged()
    }

    private fun initViews() {
        rvEducation.layoutManager = llmEducation
        rvEducation.adapter = educationAdapter
        rvEducation.isNestedScrollingEnabled = false
    }
}