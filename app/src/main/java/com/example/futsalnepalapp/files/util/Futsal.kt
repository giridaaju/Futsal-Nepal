package com.example.futsalnepalapp.files.util

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "futsals"
)

data class Futsal (
    @PrimaryKey
    var id: Int,
    var name: String,
    var address: String,
    var tole: String,
    var city: String,
    var hoursOpen: String,
    var phoneNumber: String,
    var mapsLinkUrl: String,
    var gmapsSSpath : Int
    //var price: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()!!
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(address)
        parcel.writeString(tole)
        parcel.writeString(city)
        parcel.writeString(hoursOpen)
        parcel.writeString(phoneNumber)
        parcel.writeString(mapsLinkUrl)
        parcel.writeInt(gmapsSSpath)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Futsal> {
        override fun createFromParcel(parcel: Parcel): Futsal {
            return Futsal(parcel)
        }

        override fun newArray(size: Int): Array<Futsal?> {
            return arrayOfNulls(size)
        }
    }
}
