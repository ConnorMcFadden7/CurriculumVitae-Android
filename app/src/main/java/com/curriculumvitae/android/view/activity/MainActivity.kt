package com.curriculumvitae.android.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.curriculumvitae.android.R
import com.curriculumvitae.android.domain.interactor.GetCurriculumVitaeUseCase
import com.curriculumvitae.android.view.adapter.AppHighlightAdapter
import com.curriculumvitae.android.view.adapter.EducationAdapter
import com.curriculumvitae.android.view.adapter.EmploymentHistoryAdapter
import com.curriculumvitae.android.view.adapter.TechnicalExperienceAdapter
import dagger.android.AndroidInjection
import kotterknife.bindView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var getCurriculumVitaeUseCase: GetCurriculumVitaeUseCase
    @Inject
    lateinit var appHighlightAdapter: AppHighlightAdapter
    @Inject
    lateinit var technicalExperienceAdapter: TechnicalExperienceAdapter
    @Inject
    lateinit var employmentHistoryAdapter: EmploymentHistoryAdapter
    @Inject
    lateinit var educationAdapter: EducationAdapter

    private var llmAppHighlight: LinearLayoutManager = LinearLayoutManager(this)
    private var llmTechnicalExperience: LinearLayoutManager = LinearLayoutManager(this)
    private var llmEmploymentHistory: LinearLayoutManager = LinearLayoutManager(this)
    private var llmEducation: LinearLayoutManager = LinearLayoutManager(this)

    //todo if i have time split this up into separate views
    val tvPersonName: TextView by bindView(R.id.tv_person_name)
    val tvPersonExperience: TextView by bindView(R.id.tv_person_experience)
    val tvPersonEmail: TextView by bindView(R.id.tv_person_email)
    val rvAppHighlights: RecyclerView by bindView(R.id.rv_app_highlight)
    val rvTechnicalExperience: RecyclerView by bindView(R.id.rv_technical_experience)
    val rvEmploymentHistory: RecyclerView by bindView(R.id.rv_employment_history)
    val rvEducation: RecyclerView by bindView(R.id.rv_education)
    val tvPersonDetails: TextView by bindView(R.id.tv_person_details)
    val tvReferencesAvailable: TextView by bindView(R.id.tv_references_available)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView()
        bindAppHighlightSection()
        bindTechnicalExperienceSection()
        bindEmploymentHistorySection()
        bindEducationSection()
        bindPersonDetails()
    }

    private fun bindView() {
        val curriculumVitae = getCurriculumVitaeUseCase.getCurriculumVitae()
        tvPersonName.text = curriculumVitae.person.name
        tvPersonExperience.text = curriculumVitae.person.experience
        tvPersonEmail.text = curriculumVitae.person.email
    }

    private fun bindAppHighlightSection() {
        val curriculumVitae = getCurriculumVitaeUseCase.getCurriculumVitae()
        // todo if app highlight list is empty, remove the title etc
        rvAppHighlights.layoutManager = llmAppHighlight
        rvAppHighlights.adapter = appHighlightAdapter
        rvAppHighlights.isNestedScrollingEnabled = false
        appHighlightAdapter.data = curriculumVitae.appHighlight
    }

    private fun bindTechnicalExperienceSection() {
        val curriculumVitae = getCurriculumVitaeUseCase.getCurriculumVitae()
        // todo if app highlight list is empty, remove the title etc
        rvTechnicalExperience.layoutManager = llmTechnicalExperience
        rvTechnicalExperience.adapter = technicalExperienceAdapter
        rvTechnicalExperience.isNestedScrollingEnabled = false
        technicalExperienceAdapter.data = curriculumVitae.technicalExperience
    }

    private fun bindEmploymentHistorySection() {
        val curriculumVitae = getCurriculumVitaeUseCase.getCurriculumVitae()
        // todo if app highlight list is empty, remove the title etc
        rvEmploymentHistory.layoutManager = llmEmploymentHistory
        rvEmploymentHistory.adapter = employmentHistoryAdapter
        rvEmploymentHistory.isNestedScrollingEnabled = false
        employmentHistoryAdapter.data = curriculumVitae.employmentHistory
    }

    private fun bindEducationSection() {
        val curriculumVitae = getCurriculumVitaeUseCase.getCurriculumVitae()
        // todo if app highlight list is empty, remove the title etc
        rvEducation.layoutManager = llmEducation
        rvEducation.adapter = educationAdapter
        rvEducation.isNestedScrollingEnabled = false
        educationAdapter.data = curriculumVitae.education
    }

    private fun bindPersonDetails() {
        tvPersonDetails.text = getCurriculumVitaeUseCase.getCurriculumVitae().personDetails
        tvReferencesAvailable.visibility =
                if (getCurriculumVitaeUseCase.getCurriculumVitae().showReferenceStatement) View.VISIBLE else View.GONE
    }
}
