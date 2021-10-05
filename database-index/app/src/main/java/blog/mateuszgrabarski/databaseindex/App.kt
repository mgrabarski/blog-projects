package blog.mateuszgrabarski.databaseindex

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase.JournalMode.TRUNCATE
import blog.mateuszgrabarski.databaseindex.database.AppDatabase

class App : Application() {

    private lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "database.db"
        ).setJournalMode(TRUNCATE)
            .build()
    }

    fun provideUserDao() = database.provideUserDao()
}