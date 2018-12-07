package com.curriculumvitae.android.data.model

import android.os.Parcel
import android.os.Parcelable

class CurriculumVitae(
    val person: Person,
    val appHighlight: List<AppHighlight>,
    val technicalExperience: List<TechnicalExperience>,
    val employmentHistory: List<EmploymentHistory>,
    val education: List<Education>,
    val personDetails: String,
    val showReferenceStatement: Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Person::class.java.classLoader),
        parcel.createTypedArrayList(AppHighlight),
        parcel.createTypedArrayList(TechnicalExperience),
        parcel.createTypedArrayList(EmploymentHistory),
        parcel.createTypedArrayList(Education),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(person, flags)
        parcel.writeTypedList(appHighlight)
        parcel.writeTypedList(technicalExperience)
        parcel.writeTypedList(employmentHistory)
        parcel.writeTypedList(education)
        parcel.writeString(personDetails)
        parcel.writeByte(if (showReferenceStatement) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CurriculumVitae> {
        override fun createFromParcel(parcel: Parcel): CurriculumVitae {
            return CurriculumVitae(parcel)
        }

        override fun newArray(size: Int): Array<CurriculumVitae?> {
            return arrayOfNulls(size)
        }
    }

}
