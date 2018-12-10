package com.curriculumvitae.android.data.api

import com.curriculumvitae.android.data.model.CurriculumVitae
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiCurriculumVitae {

    @GET("/ConnorMcFadden7/21fae1cf67de98457d0e4bb968ecd606/raw/b6cc2e4554210bcc7f6ed35237f36c52e70b1c57/connor_mcfadden_cv")
    fun getCurriculumVitae(): Observable<CurriculumVitae>
}
