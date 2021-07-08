package blog.mateuszgrabarski.database

import androidx.room.Database
import androidx.room.RoomDatabase
import blog.mateuszgrabarski.database.dao.ProductDao
import blog.mateuszgrabarski.database.entities.ProductEntity

internal const val DATABASE_NAME = "database"
private const val DATABASE_VERSION = 1

@Database(
    entities = [ProductEntity::class],
    version = DATABASE_VERSION
)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun provideProductDao(): ProductDao
}