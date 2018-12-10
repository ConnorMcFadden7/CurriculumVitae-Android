package com.curriculumvitae.android.di.module

import com.curriculumvitae.android.data.api.ApiCurriculumVitae
import com.curriculumvitae.android.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    @PerApplication
    fun provideCurriculumVitaeApi(@PerApplication retrofit: Retrofit): ApiCurriculumVitae {
        return retrofit.create(ApiCurriculumVitae::class.java)
    }


}