package blog.mateuszgrabarski.automigration

import android.app.Application
import androidx.room.Room
import blog.mateuszgrabarski.automigration.database.AppDatabase

class App : Application() {

    private lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        database =
            Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "database"
            ).allowMainThreadQueries()
                .build()
    }

    fun getUserDao() = database.userDao()
}