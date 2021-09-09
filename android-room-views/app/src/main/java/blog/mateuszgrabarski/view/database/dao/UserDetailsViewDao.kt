package blog.mateuszgrabarski.view.database.dao

import androidx.room.Dao
import androidx.room.Query
import blog.mateuszgrabarski.view.database.views.UserDetails

@Dao
interface UserDetailsViewDao {

    @Query("SELECT * FROM user_details WHERE id = :id")
    suspend fun getUser(id: String): UserDetails
}