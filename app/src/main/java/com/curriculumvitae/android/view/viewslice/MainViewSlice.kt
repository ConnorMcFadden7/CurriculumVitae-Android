package com.curriculumvitae.android.view.viewslice

import android.arch.lifecycle.Lifecycle
import android.view.View
import android.widget.ProgressBar
import com.curriculumvitae.android.R
import javax.inject.Inject

class MainViewSlice @Inject constructor() : BaseViewSlice() {

    private lateinit var pbLoader: ProgressBar

    override fun init(lifeCycle: Lifecycle, view: View) {
        super.init(lifeCycle, view)
        this.pbLoader = view.findViewById(R.id.pb_loader)
    }

    fun hideProgressLoader() {
        pbLoader.visibility = View.GONE
    }

}