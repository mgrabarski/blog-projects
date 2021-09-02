package blog.mateuszgrabarski.typeconverters.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import blog.mateuszgrabarski.typeconverters.database.converters.IdConverter
import blog.mateuszgrabarski.typeconverters.database.daos.UserDao
import blog.mateuszgrabarski.typeconverters.database.entities.UserEntity
import blog.mateuszgrabarski.typeconverters.database.converters.BitmapConverter
import blog.mateuszgrabarski.typeconverters.database.converters.DateConverter

private const val DATABASE_VERSION = 1

@Database(
    version = DATABASE_VERSION,
    entities = [UserEntity::class]
)
@TypeConverters(IdConverter::class, DateConverter::class, BitmapConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}