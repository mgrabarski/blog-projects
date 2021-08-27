package blog.mateuszgrabarski.databasemigration.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import blog.mateuszgrabarski.databasemigration.database.entites.UserEntity

@Dao
interface UserDao {

    @Insert
    fun insert(user: UserEntity): Long

    @Query("SELECT * FROM user WHERE id = :userId")
    fun getUserById(userId: Long): UserEntity?
}