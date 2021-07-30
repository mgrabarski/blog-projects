package blog.mateuszgrabarski.automigration.database.dao

import androidx.room.Dao
import androidx.room.Insert
import blog.mateuszgrabarski.automigration.database.entites.UserEntity

@Dao
interface UserDao {

    @Insert
    fun insert(user: UserEntity)
}