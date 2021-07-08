package blog.mateuszgrabarski.database

import android.app.Application
import androidx.room.Room

class App : Application() {

    private lateinit var database: ApplicationDatabase // nasza baza danych

    override fun onCreate() {
        super.onCreate()

        // budujemy bazę danych
        database =
        Room.databaseBuilder(
            this, // Context
            ApplicationDatabase::class.java, // Klasa opisująca bazę danych
            DATABASE_NAME // Nazwa bazy
        ).allowMainThreadQueries() // Pozwala na korzystanie z bazy w głównym wątku aplikacji
            .build()
    }

    fun providesProductDao() = database.provideProductDao()
}