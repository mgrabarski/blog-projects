package blog.mateuszgrabarski.databaseindex.database.dao

import androidx.room.Dao
import androidx.room.Insert
import blog.mateuszgrabarski.databaseindex.database.entities.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: UserEntity)

    @Insert
    suspend fun insert(users: List<UserEntity>)
}