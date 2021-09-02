package blog.mateuszgrabarski.typeconverters.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import blog.mateuszgrabarski.typeconverters.database.entities.UserEntity
import blog.mateuszgrabarski.typeconverters.database.types.LocalId

@Dao
interface UserDao {

    @Insert
    fun insert(userEntity: UserEntity)

    @Query("SELECT * FROM user WHERE id = :id")
    fun getById(id: LocalId): UserEntity?
}