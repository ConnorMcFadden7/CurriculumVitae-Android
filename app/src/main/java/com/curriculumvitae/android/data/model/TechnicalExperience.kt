package com.curriculumvitae.android.data.model

import android.os.Parcel
import android.os.Parcelable

class TechnicalExperience(val title: String, val skills: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(skills)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TechnicalExperience> {
        override fun createFromParcel(parcel: Parcel): TechnicalExperience {
            return TechnicalExperience(parcel)
        }

        override fun newArray(size: Int): Array<TechnicalExperience?> {
            return arrayOfNulls(size)
        }
    }

}