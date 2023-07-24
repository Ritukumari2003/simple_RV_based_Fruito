package com.example.rv_fruito

import android.os.Parcel
import android.os.Parcelable

data class FruitData(
    val id:Int?,
    val title:String?,
    val quality:String?,
    val overview:String?
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeString(quality)
        parcel.writeString(overview)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FruitData> {
        override fun createFromParcel(parcel: Parcel): FruitData {
            return FruitData(parcel)
        }

        override fun newArray(size: Int): Array<FruitData?> {
            return arrayOfNulls(size)
        }
    }

}
