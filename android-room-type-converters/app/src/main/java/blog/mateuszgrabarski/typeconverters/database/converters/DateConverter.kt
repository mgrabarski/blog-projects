package blog.mateuszgrabarski.typeconverters.database.converters

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun fromLongToDate(time: Long): Date = Date(time)

    @TypeConverter
    fun fromDateToLong(date: Date): Long = date.time
}