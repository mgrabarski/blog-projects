package blog.mateuszgrabarski.automigration.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import blog.mateuszgrabarski.automigration.database.dao.AddressDao
import blog.mateuszgrabarski.automigration.database.dao.UserDao
import blog.mateuszgrabarski.automigration.database.entites.AddressEntity
import blog.mateuszgrabarski.automigration.database.entites.UserEntity
import blog.mateuszgrabarski.automigration.database.migration.specifications.SpecificationForMigrationTo4

@Database(
    entities = [UserEntity::class, AddressEntity::class],
    version = 4,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
        AutoMigration(from = 2, to = 3),
        AutoMigration(from = 3, to = 4, spec = SpecificationForMigrationTo4::class)
    ]
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun addressDao(): AddressDao
}