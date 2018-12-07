package com.curriculumvitae.android.data.model

import android.os.Parcel
import android.os.Parcelable

class AppHighlight(val title: String, val shortDescription: String) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(shortDescription)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AppHighlight> {
        override fun createFromParcel(parcel: Parcel): AppHighlight {
            return AppHighlight(parcel)
        }

        override fun newArray(size: Int): Array<AppHighlight?> {
            return arrayOfNulls(size)
        }
    }

}