package com.curriculumvitae.android.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.curriculumvitae.android.R
import com.curriculumvitae.android.data.model.AppHighlight
import kotterknife.bindView

class AppHighlightViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvTitle: TextView by bindView(R.id.tv_title)
    val tvDescription: TextView by bindView(R.id.tv_description)

    fun bind(appHighlight: AppHighlight) {
        tvTitle.text = appHighlight.title
        tvDescription.text = appHighlight.shortDescription
    }

}