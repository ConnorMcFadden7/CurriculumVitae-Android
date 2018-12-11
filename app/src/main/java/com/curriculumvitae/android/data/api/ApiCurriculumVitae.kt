package com.curriculumvitae.android.data.api

import com.curriculumvitae.android.data.model.CurriculumVitae
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiCurriculumVitae {

    @GET("/ConnorMcFadden7/21fae1cf67de98457d0e4bb968ecd606/raw/ccb1ce84ac79921aa895ddb1d611d80426de9802/connor_mcfadden_cv")
    fun getCurriculumVitae(): Observable<CurriculumVitae>
}
