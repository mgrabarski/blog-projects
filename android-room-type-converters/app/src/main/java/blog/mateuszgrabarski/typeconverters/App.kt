package blog.mateuszgrabarski.typeconverters

import android.app.Application
import androidx.room.Room
import blog.mateuszgrabarski.typeconverters.database.AppDatabase

class App : Application() {

    private lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        database = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                "database"
            )
            .build()
    }

    fun provideUserDao() = database.userDao()
}