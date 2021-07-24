package blog.mateuszgrabarski.database

import android.app.Application
import androidx.room.Room
import blog.mateuszgrabarski.database.migrations.MigrationFrom2To3

class App : Application() {

    private lateinit var database: ApplicationDatabase // nasza baza danych

    override fun onCreate() {
        super.onCreate()

        // budujemy bazę danych
        database =
            Room.databaseBuilder(
                this,
                ApplicationDatabase::class.java,
                DATABASE_NAME
            ).allowMainThreadQueries()
                .addMigrations(MigrationFrom2To3())
                .build()
    }

    fun providesProductDao() = database.provideProductDao()
}