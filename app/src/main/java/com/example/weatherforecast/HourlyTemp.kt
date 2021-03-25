package com.example.weatherforecast

import android.os.Parcel
import android.os.Parcelable

data class HourlyTemp(var time:String, var temp:String, var icon:Int, var humidity:Int) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(time)
        parcel.writeString(temp)
        parcel.writeInt(icon)
        parcel.writeInt(humidity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HourlyTemp> {
        override fun createFromParcel(parcel: Parcel): HourlyTemp {
            return HourlyTemp(parcel)
        }

        override fun newArray(size: Int): Array<HourlyTemp?> {
            return arrayOfNulls(size)
        }
    }

}
