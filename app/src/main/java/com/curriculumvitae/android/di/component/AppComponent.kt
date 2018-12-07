package com.curriculumvitae.android.di.component

import com.curriculumvitae.android.CurriculumVitaeApplication
import com.curriculumvitae.android.di.module.ActivityBuilderModule
import com.curriculumvitae.android.di.scope.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: CurriculumVitaeApplication): Builder

        fun build(): AppComponent
    }

    fun inject(app: CurriculumVitaeApplication)
}