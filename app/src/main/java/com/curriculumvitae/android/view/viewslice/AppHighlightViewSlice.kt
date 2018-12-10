package com.curriculumvitae.android.view.viewslice

import android.arch.lifecycle.Lifecycle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.curriculumvitae.android.R
import com.curriculumvitae.android.data.model.AppHighlight
import com.curriculumvitae.android.view.adapter.AppHighlightAdapter
import javax.inject.Inject

class AppHighlightViewSlice @Inject constructor(val appHighlightAdapter: AppHighlightAdapter) : BaseViewSlice() {

    private lateinit var rvAppHighlights: RecyclerView
    private lateinit var tvAppHighlightLabel: TextView
    private lateinit var viewAppHighlightSeparator: View

    private lateinit var llmAppHighlight: LinearLayoutManager

    override fun init(lifeCycle: Lifecycle, view: View) {
        super.init(lifeCycle, view)
        this.rvAppHighlights = view.findViewById(R.id.rv_app_highlight)
        this.tvAppHighlightLabel = view.findViewById(R.id.tv_app_highlight_label)
        this.viewAppHighlightSeparator = view.findViewById(R.id.view_app_highlight_separator)
        this.llmAppHighlight = LinearLayoutManager(view.context)
        initViews()
    }

    fun bindAppHighlights(appHighlights: List<AppHighlight>) {
        tvAppHighlightLabel.visibility = View.VISIBLE
        viewAppHighlightSeparator.visibility = View.VISIBLE
        appHighlightAdapter.data = appHighlights
        appHighlightAdapter.notifyDataSetChanged()
    }

    private fun initViews() {
        rvAppHighlights.layoutManager = llmAppHighlight
        rvAppHighlights.adapter = appHighlightAdapter
        rvAppHighlights.isNestedScrollingEnabled = false
    }

}