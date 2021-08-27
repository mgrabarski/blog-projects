package blog.mateuszgrabarski.databasemigration

import android.app.Application
import androidx.room.Room
import blog.mateuszgrabarski.databasemigration.database.AppDatabase
import blog.mateuszgrabarski.databasemigration.database.DATABASE_NAME
import blog.mateuszgrabarski.databasemigration.database.migrations.MigrationTo2

class App : Application() {

    private lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            DATABASE_NAME
        ).addMigrations(MigrationTo2())
            .build()
    }

    fun provideUserDao() = database.provideUserDao()
}