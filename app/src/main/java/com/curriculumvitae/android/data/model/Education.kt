package com.curriculumvitae.android.data.model

import android.os.Parcel
import android.os.Parcelable

class Education(
    val location: String,
    val startDate: String,
    val endDate: String,
    val educationLevel: String,
    val course: String,
    val grades: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(location)
        parcel.writeString(startDate)
        parcel.writeString(endDate)
        parcel.writeString(educationLevel)
        parcel.writeString(course)
        parcel.writeString(grades)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Education> {
        override fun createFromParcel(parcel: Parcel): Education {
            return Education(parcel)
        }

        override fun newArray(size: Int): Array<Education?> {
            return arrayOfNulls(size)
        }
    }

}