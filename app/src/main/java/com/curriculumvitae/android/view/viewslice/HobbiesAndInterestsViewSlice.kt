package com.curriculumvitae.android.view.viewslice

import android.arch.lifecycle.Lifecycle
import android.view.View
import android.widget.TextView
import com.curriculumvitae.android.R
import javax.inject.Inject

class HobbiesAndInterestsViewSlice @Inject constructor() : BaseViewSlice() {

    private lateinit var tvPersonDetails: TextView
    private lateinit var tvReferencesAvailable: TextView
    private lateinit var tvPersonDetailsLabel: TextView
    private lateinit var viewPersonDetailsSeparator: View

    override fun init(lifeCycle: Lifecycle, view: View) {
        super.init(lifeCycle, view)
        this.tvPersonDetails = view.findViewById(R.id.tv_person_details)
        this.tvReferencesAvailable = view.findViewById(R.id.tv_references_available)
        this.tvPersonDetailsLabel = view.findViewById(R.id.tv_person_details_label)
        this.viewPersonDetailsSeparator = view.findViewById(R.id.view_person_details_separator)
    }

    fun bindPersonDetails(personDetails: String) {
        tvPersonDetails.text = personDetails
        tvPersonDetailsLabel.visibility = View.VISIBLE
        viewPersonDetailsSeparator.visibility = View.VISIBLE
    }

    fun showReferencesAvailable() {
        tvReferencesAvailable.visibility = View.VISIBLE
    }

}