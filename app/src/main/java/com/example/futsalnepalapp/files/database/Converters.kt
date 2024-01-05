package com.example.futsalnepalapp.files.database

import androidx.room.TypeConverter
import com.example.futsalnepalapp.files.util.HoursOpen

class Converters {

    @TypeConverter
    fun fromHoursOpen(hoursOpen: HoursOpen): String {
        return "placeholder"
    }

    @TypeConverter
    fun toHoursOpen(hours: String): HoursOpen {
        return HoursOpen("000", "000")
    }
}