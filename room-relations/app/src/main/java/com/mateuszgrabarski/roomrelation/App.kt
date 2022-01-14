package com.mateuszgrabarski.roomrelation

import android.app.Application
import androidx.room.Room
import com.mateuszgrabarski.roomrelation.database.AppDatabase

class App : Application() {

    private lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "database_name"
        ).build()
    }

    fun provideUserDao() = database.provideUserDao()

    fun provideIdentificationCardDao() = database.provideIdentificationCardDao()

    fun providePostsDao() = database.providePostsDao()

    fun provideTagDao() = database.provideTagDao()
}