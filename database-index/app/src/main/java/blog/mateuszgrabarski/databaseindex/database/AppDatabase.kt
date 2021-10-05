package blog.mateuszgrabarski.databaseindex.database

import androidx.room.Database
import androidx.room.RoomDatabase
import blog.mateuszgrabarski.databaseindex.database.dao.UserDao
import blog.mateuszgrabarski.databaseindex.database.entities.UserEntity

private const val DATABASE_VERSION = 1

@Database(
    entities = [UserEntity::class],
    version = DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun provideUserDao(): UserDao
}