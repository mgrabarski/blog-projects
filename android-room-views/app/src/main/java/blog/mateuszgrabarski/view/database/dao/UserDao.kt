package blog.mateuszgrabarski.view.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import blog.mateuszgrabarski.view.database.entity.UserEntity

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: UserEntity)

    @Query("UPDATE user SET password = :newPassword WHERE id = :userId")
    suspend fun updateUserPassword(userId: String, newPassword: String)
}