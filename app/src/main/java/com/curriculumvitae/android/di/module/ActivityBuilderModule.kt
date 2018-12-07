package com.curriculumvitae.android.di.module

import com.curriculumvitae.android.view.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector()
    abstract fun bindMainActivity(): MainActivity

}