package blog.mateuszgrabarski.prepopulate.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import blog.mateuszgrabarski.prepopulate.database.entities.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: UserEntity)

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<UserEntity>
}