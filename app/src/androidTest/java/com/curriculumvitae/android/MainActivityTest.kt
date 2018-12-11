package com.curriculumvitae.android

import org.junit.runner.RunWith
import org.junit.Before
import org.junit.Test
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.curriculumvitae.android.data.model.CurriculumVitae
import com.curriculumvitae.android.view.activity.MainActivity
import com.curriculumvitae.android.view.adapter.AppHighlightAdapter
import com.curriculumvitae.android.view.adapter.EducationAdapter
import com.curriculumvitae.android.view.adapter.EmploymentHistoryAdapter
import com.curriculumvitae.android.view.adapter.TechnicalExperienceAdapter
import com.curriculumvitae.android.view.viewslice.*
import com.utils.TestDataUtils
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    val viewSliceHelper: ViewSliceHelper = ViewSliceHelper()
    val personDetailsViewSlice: PersonDetailsViewSlice = PersonDetailsViewSlice()
    lateinit var appHighlightViewSlice: AppHighlightViewSlice
    lateinit var employmentHistoryViewSlice: EmploymentHistoryViewSlice
    lateinit var technicalExperienceViewSlice: TechnicalExperienceViewSlice
    lateinit var educationViewSlice: EducationViewSlice
    var hobbiesAndInterestsViewSlice: HobbiesAndInterestsViewSlice = HobbiesAndInterestsViewSlice()
    val appHighlightAdapter: AppHighlightAdapter = AppHighlightAdapter()
    val technicalExperienceAdapter: TechnicalExperienceAdapter = TechnicalExperienceAdapter()
    val employmentHistoryAdapter: EmploymentHistoryAdapter = EmploymentHistoryAdapter()
    val educationAdapter: EducationAdapter = EducationAdapter()
    val curriculumVitae: CurriculumVitae = TestDataUtils().getCurriculumVitae()

    @Before
    fun setUp() {
        appHighlightViewSlice = AppHighlightViewSlice(appHighlightAdapter)
        technicalExperienceViewSlice = TechnicalExperienceViewSlice(technicalExperienceAdapter)
        employmentHistoryViewSlice = EmploymentHistoryViewSlice(employmentHistoryAdapter)
        educationViewSlice = EducationViewSlice(educationAdapter)
        runOnUiThread {
            viewSliceHelper.initWidget(
                activityRule.activity.lifecycle,
                activityRule.activity.findViewById(R.id.container_curriculum_vitae),
                personDetailsViewSlice,
                appHighlightViewSlice,
                technicalExperienceViewSlice,
                employmentHistoryViewSlice,
                educationViewSlice,
                hobbiesAndInterestsViewSlice
            )
            personDetailsViewSlice.bindPersonName(curriculumVitae.person.name)
            personDetailsViewSlice.bindPersonExperience(curriculumVitae.person.experience)
            personDetailsViewSlice.bindPersonEmail(curriculumVitae.person.email)
            appHighlightViewSlice.bindAppHighlights(curriculumVitae.appHighlight)
            technicalExperienceViewSlice.bindTechnicalExperiences(curriculumVitae.technicalExperience)
            employmentHistoryViewSlice.bindEmploymentHistory(curriculumVitae.employmentHistory)
            educationViewSlice.bindEducation(curriculumVitae.education)
            hobbiesAndInterestsViewSlice.bindPersonDetails(curriculumVitae.personDetails)
        }
    }

    @Test
    fun test_personDetails() {
        onView(withId(R.id.tv_person_name)).check(matches(withText(curriculumVitae.person.name)))
        onView(withId(R.id.tv_person_experience)).check(matches(withText(curriculumVitae.person.experience)))
        onView(withId(R.id.tv_person_email)).check(matches(withText(curriculumVitae.person.email)))
    }

    @Test
    fun test_appHighlight() {
        onView(withId(R.id.tv_app_highlight_label)).check(matches((isDisplayed())))
        onView(withId(R.id.view_app_highlight_separator)).check(matches((isDisplayed())))
        onView(withId(R.id.rv_app_highlight))
            .check(matches(hasDescendant(withText(curriculumVitae.appHighlight.get(0).title))))
        onView(withId(R.id.rv_app_highlight))
            .check(matches(hasDescendant(withText(curriculumVitae.appHighlight.get(0).shortDescription))))
    }

    @Test
    fun test_technicalExperience() {
        onView(withId(R.id.tv_technical_experience_label)).check(matches((isDisplayed())))
        onView(withId(R.id.view_technical_experience_separator)).check(matches((isDisplayed())))
        onView(withId(R.id.rv_technical_experience))
            .check(matches(hasDescendant(withText(curriculumVitae.technicalExperience.get(0).title))))
        onView(withId(R.id.rv_technical_experience))
            .check(matches(hasDescendant(withText(curriculumVitae.technicalExperience.get(0).skills))))
    }

    @Test
    fun test_employmentHistory() {
        onView(withId(R.id.container_curriculum_vitae)).perform(swipeUp(), click())
        val employmentHistory = curriculumVitae.employmentHistory.get(0)
        onView(withId(R.id.tv_employment_history_label)).check(matches((isDisplayed())))
        onView(withId(R.id.view_employment_history_separator)).check(matches((isDisplayed())))
        //todo We could put this in a helper class and have a unit test
        onView(withId(R.id.rv_employment_history))
            .check(matches(hasDescendant(withText(employmentHistory.role + ", " + employmentHistory.company + ", " + employmentHistory.location + " - " + employmentHistory.startDate + " - " + employmentHistory.endDate))))
    }

    @Test
    fun test_education() {
        onView(withId(R.id.container_curriculum_vitae)).perform(swipeUp(), click())
        val education = curriculumVitae.education.get(0)
        onView(withId(R.id.tv_education_label)).check(matches((isDisplayed())))
        onView(withId(R.id.view_education_separator)).check(matches((isDisplayed())))
        //todo We could put this in a helper class and have a unit test
        onView(withId(R.id.rv_education))
            .check(matches(hasDescendant(withText(education.location + ", " + education.startDate + " - " + education.endDate))))
    }

    @Test
    fun test_hobbiesAndInterests() {
        onView(withId(R.id.tv_person_details)).check(matches(withText(curriculumVitae.personDetails)))
        onView(withId(R.id.container_curriculum_vitae)).perform(swipeUp(), click())
        onView(withId(R.id.tv_person_details_label)).check(matches((isDisplayed())))
        onView(withId(R.id.view_person_details_separator)).check(matches((isDisplayed())))
    }
}