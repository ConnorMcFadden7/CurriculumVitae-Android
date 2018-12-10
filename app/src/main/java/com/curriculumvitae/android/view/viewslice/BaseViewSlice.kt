package com.curriculumvitae.android.view.viewslice

import android.arch.lifecycle.Lifecycle
import android.view.View

abstract class BaseViewSlice : ViewSlice {

    override fun init(lifeCycle: Lifecycle, view: View) {
        lifeCycle.addObserver(this)
    }
}
