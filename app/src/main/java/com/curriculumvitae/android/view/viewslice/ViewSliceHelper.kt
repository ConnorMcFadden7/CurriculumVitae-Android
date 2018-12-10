package com.curriculumvitae.android.view.viewslice

import android.arch.lifecycle.Lifecycle
import android.view.View
import javax.inject.Inject

class ViewSliceHelper @Inject constructor() {

    fun initWidget(lifecycle: Lifecycle, view: View, vararg viewSlices: ViewSlice) {
        for (viewSlice in viewSlices) {
            viewSlice.init(lifecycle, view)
        }
    }

}