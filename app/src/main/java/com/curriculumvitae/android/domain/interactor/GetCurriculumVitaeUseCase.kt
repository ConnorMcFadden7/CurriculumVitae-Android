package com.curriculumvitae.android.domain.interactor

import com.curriculumvitae.android.data.model.*
import javax.inject.Inject

class GetCurriculumVitaeUseCase @Inject constructor() {

    fun getCurriculumVitae(): CurriculumVitae {
        //todo we could use this in a test
        var person = Person("Connor McFadden", "connormcfadden7@gmail.com", "4 years experience")
        var appHighlightList = mutableListOf<AppHighlight>()
        var appHighlight = AppHighlight("Memrise", "Memrise is an education app")
        appHighlightList.add(appHighlight)
        appHighlightList.add(appHighlight)

        var technicalExperienceList = mutableListOf<TechnicalExperience>()
        var technicalExperience = TechnicalExperience("Technical", "Kotlin, java, swift")
        technicalExperienceList.add(technicalExperience)
        technicalExperienceList.add(technicalExperience)

        var employmentHistoryList = mutableListOf<EmploymentHistory>()
        var employmentHistory = EmploymentHistory(
            "Senior Android Developer",
            "London Techworks",
            "London",
            "28th Feb",
            "Present",
            "I worked there for DHL"
        )
        employmentHistoryList.add(employmentHistory)
        employmentHistoryList.add(employmentHistory)

        var educationList = mutableListOf<Education>()
        var education = Education("Swansea University", "2014", "2015", "Bachelors degree", "Computer Science", "1st")
        educationList.add(education)
        educationList.add(education)

        return CurriculumVitae(
            person,
            appHighlightList,
            technicalExperienceList,
            employmentHistoryList,
            educationList,
            "Love keeping up with tech",
            true
        )
    }

}