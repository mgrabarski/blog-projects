package blog.mateuszgrabarski.prepopulate.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import blog.mateuszgrabarski.prepopulate.database.dao.UserDao
import blog.mateuszgrabarski.prepopulate.database.entities.UserEntity

@Database(
    version = 1,
    entities = [UserEntity::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun provideUserDao(): UserDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "database.db"
            ).createFromAsset(getDatabaseFromAssets())
                .build()

        private fun getDatabaseFromAssets() = "debug_database/database.db"
    }
}