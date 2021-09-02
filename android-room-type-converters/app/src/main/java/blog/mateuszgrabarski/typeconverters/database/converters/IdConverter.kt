package blog.mateuszgrabarski.typeconverters.database.converters

import androidx.room.TypeConverter
import blog.mateuszgrabarski.typeconverters.database.types.LocalId

class IdConverter {

    @TypeConverter
    fun fromIdToString(id: LocalId): String = id.toString()

    @TypeConverter
    fun fromStringToLocalId(id: String): LocalId = LocalId.fromString(id)
}