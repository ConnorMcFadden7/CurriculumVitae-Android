package com.curriculumvitae.android.domain.interactor

import com.curriculumvitae.android.data.model.*
import com.curriculumvitae.android.domain.repository.CurriculumVitaeRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetCurriculumVitaeUseCase @Inject constructor(val curriculumVitaeRepository: CurriculumVitaeRepository) {

    fun getCurriculumVitae(): Observable<CurriculumVitae> {
        return curriculumVitaeRepository.getCurriculumVitae().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}