package blog.mateuszgrabarski.view

import android.app.Application
import androidx.room.Room
import blog.mateuszgrabarski.view.database.AppDatabase

class App : Application() {

    private lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "database"
        ).build()
    }

    fun provideUserDao() = database.provideUserDao()

    fun provideViewDao() = database.provideUserDetailsDao()

    fun provideCategoryDao() = database.provideCategoryDao()

    fun provideSubcategoryDao() = database.provideSubcategoryDao()

    fun provideUserCategoryViewDao() = database.provideUserCategoryViewDao()
}