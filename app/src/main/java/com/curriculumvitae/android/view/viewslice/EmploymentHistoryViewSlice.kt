package com.curriculumvitae.android.view.viewslice

import android.arch.lifecycle.Lifecycle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.curriculumvitae.android.R
import com.curriculumvitae.android.data.model.EmploymentHistory
import com.curriculumvitae.android.view.adapter.EmploymentHistoryAdapter
import javax.inject.Inject

class EmploymentHistoryViewSlice @Inject constructor(val employmentHistoryAdapter: EmploymentHistoryAdapter) :
    BaseViewSlice() {

    private lateinit var rvEmploymentHistory: RecyclerView
    private lateinit var tvEmploymentHistoryLabel: TextView
    private lateinit var viewEmploymentHistorySeparator: View

    private lateinit var llmEmploymentHistory: LinearLayoutManager

    override fun init(lifeCycle: Lifecycle, view: View) {
        super.init(lifeCycle, view)
        this.rvEmploymentHistory = view.findViewById(R.id.rv_employment_history)
        this.tvEmploymentHistoryLabel = view.findViewById(R.id.tv_employment_history_label)
        this.viewEmploymentHistorySeparator = view.findViewById(R.id.view_employment_history_separator)
        this.llmEmploymentHistory = LinearLayoutManager(view.context)
        initViews()
    }

    fun bindEmploymentHistory(employmentHistoryList: List<EmploymentHistory>) {
        tvEmploymentHistoryLabel.visibility = View.VISIBLE
        viewEmploymentHistorySeparator.visibility = View.VISIBLE
        employmentHistoryAdapter.data = employmentHistoryList
        employmentHistoryAdapter.notifyDataSetChanged()
    }

    private fun initViews() {
        rvEmploymentHistory.layoutManager = llmEmploymentHistory
        rvEmploymentHistory.adapter = employmentHistoryAdapter
        rvEmploymentHistory.isNestedScrollingEnabled = false
    }

}