package com.curriculumvitae.android.view.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.curriculumvitae.android.data.model.CurriculumVitaeResponse
import com.curriculumvitae.android.domain.interactor.GetCurriculumVitaeUseCase
import com.curriculumvitae.android.utils.NetworkUtils
import javax.inject.Inject

class MainViewModel @Inject constructor(
    val getCurriculumVitaeUseCase: GetCurriculumVitaeUseCase,
    val networkUtils: NetworkUtils
) : ViewModel() {

    private var mutableLiveData: MutableLiveData<CurriculumVitaeResponse> = MutableLiveData()

    fun getCurriculumVitae(context: Context) {
        val curriculumVitaeResponse = CurriculumVitaeResponse()
        if (networkUtils.isConnected(context)) {
            getCurriculumVitaeUseCase.getCurriculumVitae().subscribe({
                curriculumVitaeResponse.curriculumVitae = it
                curriculumVitaeResponse.statusCode = CurriculumVitaeResponse.StatusCode.SUCCESS
                mutableLiveData.value = curriculumVitaeResponse
            }, {
                curriculumVitaeResponse.statusCode = CurriculumVitaeResponse.StatusCode.GENERIC_ERROR
                mutableLiveData.value = curriculumVitaeResponse
            })
        } else {
            curriculumVitaeResponse.statusCode = CurriculumVitaeResponse.StatusCode.NO_NETWORK
            mutableLiveData.value = curriculumVitaeResponse
        }
    }

    fun getMutableLiveDataCurriculumVitae(): MutableLiveData<CurriculumVitaeResponse> {
        return mutableLiveData
    }
}