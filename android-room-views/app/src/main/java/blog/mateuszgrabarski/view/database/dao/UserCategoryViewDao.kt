package blog.mateuszgrabarski.view.database.dao

import androidx.room.Dao
import androidx.room.Query
import blog.mateuszgrabarski.view.database.views.UserCategories

@Dao
interface UserCategoryViewDao {

    @Query("SELECT * FROM user_categories WHERE user_id = :userId")
    fun getUserCategories(userId: String): List<UserCategories>
}