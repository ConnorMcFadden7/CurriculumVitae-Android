package com.utils

import com.curriculumvitae.android.data.model.*

class TestDataUtils() {

    fun getCurriculumVitae(): CurriculumVitae {
        //todo we could use this in a test
        var person = Person("Connor McFadden", "connormcfadden7@gmail.com", "4 years experience")
        var appHighlightList = mutableListOf<AppHighlight>()
        var appHighlight = AppHighlight("Memrise", "Memrise is an education app")
        appHighlightList.add(appHighlight)

        var technicalExperienceList = mutableListOf<TechnicalExperience>()
        var technicalExperience = TechnicalExperience("Technical", "Kotlin, Java, Android, Swift")
        technicalExperienceList.add(technicalExperience)

        var employmentHistoryList = mutableListOf<EmploymentHistory>()
        var employmentHistory = EmploymentHistory(
            "Senior Android Developer",
            "London Techworks",
            "London",
            "28th Feb",
            "Present",
            "Worked on an app for DHL"
        )
        employmentHistoryList.add(employmentHistory)

        var educationList = mutableListOf<Education>()
        var education = Education("Swansea University", "2011", "2014", "Bachelors degree", "Computer Science", "1st")
        educationList.add(education)

        val cv = CurriculumVitae(
            person,
            appHighlightList,
            technicalExperienceList,
            employmentHistoryList,
            educationList,
            "Keeping up to date with the latest technology",
            true
        )

        return cv
    }

}