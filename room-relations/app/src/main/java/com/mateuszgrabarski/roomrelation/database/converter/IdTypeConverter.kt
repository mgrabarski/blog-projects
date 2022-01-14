package com.mateuszgrabarski.roomrelation.database.converter

import androidx.room.TypeConverter
import com.mateuszgrabarski.roomrelation.database.types.Id

class IdTypeConverter {

    @TypeConverter
    fun fromStringToId(stringId: String) = Id.fromString(stringId)

    @TypeConverter
    fun fromIdToString(id: Id) = id.toString()
}