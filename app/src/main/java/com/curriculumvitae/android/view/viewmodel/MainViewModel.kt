package com.curriculumvitae.android.view.viewmodel

import android.arch.lifecycle.ViewModel
import com.curriculumvitae.android.data.model.CurriculumVitae
import com.curriculumvitae.android.domain.interactor.GetCurriculumVitaeUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(val getCurriculumVitaeUseCase: GetCurriculumVitaeUseCase) : ViewModel() {

    fun getCurriculumVitae() : CurriculumVitae {
//        acceptTermsUseCase.acceptTerms(termsAndConditions)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe({ mutableLiveDataAcceptTerms.setValue(1) },
//                { throwable -> mutableLiveDataAcceptTerms.setValue(0) })
        return getCurriculumVitaeUseCase.getCurriculumVitae()
    }

//    fun getMutableLiveDataAcceptTerms(): MutableLiveData<Int> {
//        return mutableLiveDataAcceptTerms
//    }

}