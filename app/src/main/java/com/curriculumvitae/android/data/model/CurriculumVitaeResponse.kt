package com.curriculumvitae.android.data.model

class CurriculumVitaeResponse() {

    enum class StatusCode {

        SUCCESS, NO_NETWORK, GENERIC_ERROR

    }

    lateinit var curriculumVitae: CurriculumVitae
    lateinit var statusCode: StatusCode

}