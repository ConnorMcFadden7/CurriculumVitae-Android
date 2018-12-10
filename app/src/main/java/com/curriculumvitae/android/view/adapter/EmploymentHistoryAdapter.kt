package com.curriculumvitae.android.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.curriculumvitae.android.R
import com.curriculumvitae.android.data.model.EmploymentHistory
import javax.inject.Inject

class EmploymentHistoryAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: List<EmploymentHistory> = mutableListOf()
        get() = field
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EmploymentHistoryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_employment_history,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val employmentHistoryViewHolder = holder as EmploymentHistoryViewHolder
        employmentHistoryViewHolder.bind(data.get(position))
    }

}