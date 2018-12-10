package com.curriculumvitae.android.view.activity

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.curriculumvitae.android.R
import com.curriculumvitae.android.data.model.CurriculumVitae
import com.curriculumvitae.android.view.viewmodel.MainViewModel
import com.curriculumvitae.android.view.viewslice.*
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel
    @Inject
    lateinit var viewSliceHelper: ViewSliceHelper
    @Inject
    lateinit var mainViewSlice: MainViewSlice
    @Inject
    lateinit var personDetailsViewSlice: PersonDetailsViewSlice
    @Inject
    lateinit var appHighlightViewSlice: AppHighlightViewSlice
    @Inject
    lateinit var technicalExperienceViewSlice: TechnicalExperienceViewSlice
    @Inject
    lateinit var employmentHistoryViewSlice: EmploymentHistoryViewSlice
    @Inject
    lateinit var educationViewSlice: EducationViewSlice
    @Inject
    lateinit var hobbiesAndInterestsViewSlice: HobbiesAndInterestsViewSlice


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
    }

    private fun bindView() {
        viewSliceHelper.initWidget(
            lifecycle,
            findViewById(R.id.container_curriculum_vitae),
            mainViewSlice,
            personDetailsViewSlice,
            appHighlightViewSlice,
            technicalExperienceViewSlice,
            employmentHistoryViewSlice,
            educationViewSlice,
            hobbiesAndInterestsViewSlice
        )
        viewModel.getCurriculumVitae()
        viewModel.getMutableLiveDataCurriculumVitae().observe(this, Observer {
            mainViewSlice.hideProgressLoader()
            bindPersonDetails(it!!)
            bindAppHighlightsSection(it)
            bindTechnicalExperienceSection(it)
            bindEmploymentHistorySection(it)
            bindEducationSection(it)
            bindHobbiesAndInterests(it)
        })
    }

    private fun bindPersonDetails(curriculumVitae: CurriculumVitae) {
        personDetailsViewSlice.bindPersonName(curriculumVitae.person.name)
        personDetailsViewSlice.bindPersonExperience(curriculumVitae.person.experience)
        personDetailsViewSlice.bindPersonEmail(curriculumVitae.person.email)
    }

    private fun bindAppHighlightsSection(curriculumVitae: CurriculumVitae) {
        if (curriculumVitae.technicalExperience.isNotEmpty()) {
            appHighlightViewSlice.bindAppHighlights(curriculumVitae.appHighlight)
        }
    }

    private fun bindTechnicalExperienceSection(curriculumVitae: CurriculumVitae) {
        if (curriculumVitae.technicalExperience.isNotEmpty()) {
            technicalExperienceViewSlice.bindTechnicalExperiences(curriculumVitae.technicalExperience)
        }
    }

    private fun bindEmploymentHistorySection(curriculumVitae: CurriculumVitae) {
        if (curriculumVitae.employmentHistory.isNotEmpty()) {
            employmentHistoryViewSlice.bindEmploymentHistory(curriculumVitae.employmentHistory)
        }
    }

    private fun bindEducationSection(curriculumVitae: CurriculumVitae) {
        if (curriculumVitae.education.isNotEmpty()) {
            educationViewSlice.bindEducation(curriculumVitae.education)
        }
    }

    private fun bindHobbiesAndInterests(curriculumVitae: CurriculumVitae) {
        hobbiesAndInterestsViewSlice.bindPersonDetails(curriculumVitae.personDetails)
        if (curriculumVitae.showReferenceStatement) hobbiesAndInterestsViewSlice.showReferencesAvailable()
    }
}
