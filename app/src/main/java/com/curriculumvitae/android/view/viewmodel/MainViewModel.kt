package com.curriculumvitae.android.view.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.curriculumvitae.android.data.model.CurriculumVitae
import com.curriculumvitae.android.domain.interactor.GetCurriculumVitaeUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(val getCurriculumVitaeUseCase: GetCurriculumVitaeUseCase) : ViewModel() {

    private var mutableLiveData: MutableLiveData<CurriculumVitae> = MutableLiveData()

    fun getCurriculumVitae() {
//        acceptTermsUseCase.acceptTerms(termsAndConditions)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe({ mutableLiveDataAcceptTerms.setValue(1) },
//                { throwable -> mutableLiveDataAcceptTerms.setValue(0) })
        getCurriculumVitaeUseCase.getCurriculumVitae().subscribe({
            mutableLiveData.value = it
            Log.e("ConnorDebug", "testing name: " + it.person.name)
        }, {
            // handle error
            Log.e("ConnorDebug", "error: " + it.localizedMessage)

        })
    }

    fun getMutableLiveDataCurriculumVitae(): MutableLiveData<CurriculumVitae> {
        return mutableLiveData
    }
}