package com.curriculumvitae.android.domain.repository

import com.curriculumvitae.android.data.api.ApiCurriculumVitae
import com.curriculumvitae.android.data.model.CurriculumVitae
import io.reactivex.Observable
import javax.inject.Inject

class CurriculumVitaeRepository @Inject constructor(val apiCurriculumVitae: ApiCurriculumVitae) {

    fun getCurriculumVitae(): Observable<CurriculumVitae> {
        return apiCurriculumVitae.getCurriculumVitae()
    }
}