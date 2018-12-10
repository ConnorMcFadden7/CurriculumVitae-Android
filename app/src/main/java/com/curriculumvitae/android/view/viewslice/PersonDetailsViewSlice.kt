package com.curriculumvitae.android.view.viewslice

import android.arch.lifecycle.Lifecycle
import android.view.View
import android.widget.TextView
import com.curriculumvitae.android.R
import javax.inject.Inject

class PersonDetailsViewSlice @Inject constructor() : BaseViewSlice() {

    private lateinit var tvPersonName: TextView
    private lateinit var tvPersonExperience: TextView
    private lateinit var tvPersonEmail: TextView

    override fun init(lifeCycle: Lifecycle, view: View) {
        super.init(lifeCycle, view)
        this.tvPersonName = view.findViewById(R.id.tv_person_name)
        this.tvPersonExperience = view.findViewById(R.id.tv_person_experience)
        this.tvPersonEmail = view.findViewById(R.id.tv_person_email)
    }

    fun bindPersonName(personName: String) {
        tvPersonName.text = personName
    }

    fun bindPersonExperience(personExperience: String) {
        tvPersonExperience.text = personExperience
    }

    fun bindPersonEmail(personEmail: String) {
        tvPersonEmail.text = personEmail
    }

}