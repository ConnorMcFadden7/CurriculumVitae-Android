package com.curriculumvitae.android.view.viewslice

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.view.View

interface ViewSlice : LifecycleObserver {

    fun init(lifeCycle: Lifecycle, view: View)
}
