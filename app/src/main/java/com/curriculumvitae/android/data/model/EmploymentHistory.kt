package com.curriculumvitae.android.data.model

import android.os.Parcel
import android.os.Parcelable

class EmploymentHistory(
    val role: String,
    val company: String,
    val location: String,
    val startDate: String,
    val endDate: String,
    val description: String
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
        parcel.writeString(role)
        parcel.writeString(company)
        parcel.writeString(location)
        parcel.writeString(startDate)
        parcel.writeString(endDate)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EmploymentHistory> {
        override fun createFromParcel(parcel: Parcel): EmploymentHistory {
            return EmploymentHistory(parcel)
        }

        override fun newArray(size: Int): Array<EmploymentHistory?> {
            return arrayOfNulls(size)
        }
    }

}