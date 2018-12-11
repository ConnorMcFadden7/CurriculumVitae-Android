package com.curriculumvitae.android.view.viewslice

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.view.View

/**
 * ViewSlice interface responsible for initialising sub ViewSlices. The purpose of a ViewSlice is to extract
 * complex view logic/binding from Activities or Fragments to reduce boilerplate code. ViewSlices also make view
 * components much easier to test.
 */
interface ViewSlice : LifecycleObserver {

    fun init(lifeCycle: Lifecycle, view: View)
}
