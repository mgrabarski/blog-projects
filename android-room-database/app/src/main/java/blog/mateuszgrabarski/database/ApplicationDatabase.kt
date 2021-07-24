package blog.mateuszgrabarski.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import blog.mateuszgrabarski.database.dao.ProductDao
import blog.mateuszgrabarski.database.entities.ProductEntity

internal const val DATABASE_NAME = "database"
private const val DATABASE_VERSION = 3

@Database(
    entities = [ProductEntity::class],
    version = DATABASE_VERSION,
    autoMigrations = [AutoMigration(from = 1, to = 2)]
)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun provideProductDao(): ProductDao
}