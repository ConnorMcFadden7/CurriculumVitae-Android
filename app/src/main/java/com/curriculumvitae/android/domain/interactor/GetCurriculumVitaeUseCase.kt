package com.curriculumvitae.android.domain.interactor

import com.curriculumvitae.android.data.model.*
import com.curriculumvitae.android.domain.repository.CurriculumVitaeRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetCurriculumVitaeUseCase @Inject constructor(val curriculumVitaeRepository: CurriculumVitaeRepository) {

    /*fun getCurriculumVitae(): CurriculumVitae {
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

        val cv = CurriculumVitae(
            person,
            appHighlightList,
            technicalExperienceList,
            employmentHistoryList,
            educationList,
            "Love keeping up with tech",
            true
        )


        val json = Gson().toJson(cv)
        Log.e("ConnorDebug", "cv json: " + json)

        return cv
    }*/

    fun getCurriculumVitae(): Observable<CurriculumVitae> {
        return curriculumVitaeRepository.getCurriculumVitae().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}