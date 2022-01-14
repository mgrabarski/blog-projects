package com.mateuszgrabarski.roomrelation.database.converter

import androidx.room.TypeConverter
import com.mateuszgrabarski.roomrelation.database.types.DatabaseDate
import java.text.DateFormat
import java.util.*

class DatabaseDateTypeConverter {

    @TypeConverter
    fun fromStringToDate(stringDate: String): DatabaseDate =
        DateFormat.getDateInstance().parse(stringDate)!!

    @TypeConverter
    fun fromDateToString(date: Date): String = DateFormat.getDateInstance().format(date)
}