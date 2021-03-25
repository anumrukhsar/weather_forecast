package com.example.weatherforecast.ui.theme

import android.graphics.drawable.Icon
import android.os.Parcel
import android.os.Parcelable

data class DailyTemp(var day:String, var humidity:Int ,var dayIcon:Int , var nightIcon: Int, var temp:String) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(day)
        parcel.writeInt(humidity)
        parcel.writeInt(dayIcon)
        parcel.writeInt(nightIcon)
        parcel.writeString(temp)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DailyTemp> {
        override fun createFromParcel(parcel: Parcel): DailyTemp {
            return DailyTemp(parcel)
        }

        override fun newArray(size: Int): Array<DailyTemp?> {
            return arrayOfNulls(size)
        }
    }

}
