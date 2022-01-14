package com.mateuszgrabarski.roomrelation.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mateuszgrabarski.roomrelation.database.converter.DatabaseDateTypeConverter
import com.mateuszgrabarski.roomrelation.database.converter.IdTypeConverter
import com.mateuszgrabarski.roomrelation.database.dao.IdentificationCardDao
import com.mateuszgrabarski.roomrelation.database.dao.PostsDao
import com.mateuszgrabarski.roomrelation.database.dao.TagDao
import com.mateuszgrabarski.roomrelation.database.dao.UserDao
import com.mateuszgrabarski.roomrelation.database.entities.*

@Database(
    entities = [User::class, IdentificationCard::class, Post::class, Tag::class, PostAndTagRef::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(IdTypeConverter::class, DatabaseDateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun provideUserDao(): UserDao

    abstract fun provideIdentificationCardDao(): IdentificationCardDao

    abstract fun providePostsDao(): PostsDao

    abstract fun provideTagDao(): TagDao
}