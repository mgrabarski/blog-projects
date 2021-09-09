package blog.mateuszgrabarski.view.database

import androidx.room.Database
import androidx.room.RoomDatabase
import blog.mateuszgrabarski.view.database.dao.*
import blog.mateuszgrabarski.view.database.entity.CategoryEntity
import blog.mateuszgrabarski.view.database.entity.SubcategoryEntity
import blog.mateuszgrabarski.view.database.entity.UserEntity
import blog.mateuszgrabarski.view.database.views.UserCategories
import blog.mateuszgrabarski.view.database.views.UserDetails

private const val DATABASE_VERSION = 1

@Database(
    version = DATABASE_VERSION,
    entities = [UserEntity::class, CategoryEntity::class, SubcategoryEntity::class],
    views = [UserDetails::class, UserCategories::class]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun provideUserDao(): UserDao

    abstract fun provideUserDetailsDao(): UserDetailsViewDao

    abstract fun provideCategoryDao(): CategoryDao

    abstract fun provideSubcategoryDao(): SubcategoryDao

    abstract fun provideUserCategoryViewDao(): UserCategoryViewDao
}