package blog.mateuszgrabarski.databasemigration.database

import androidx.room.Database
import androidx.room.RoomDatabase
import blog.mateuszgrabarski.databasemigration.database.daos.UserDao
import blog.mateuszgrabarski.databasemigration.database.entites.UserEntity

private const val DATABASE_VERSION = 2
const val DATABASE_NAME = "app-database"

@Database(
    entities = [UserEntity::class],
    version = DATABASE_VERSION,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun provideUserDao(): UserDao
}