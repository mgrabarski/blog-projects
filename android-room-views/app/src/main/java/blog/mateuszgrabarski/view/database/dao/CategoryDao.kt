package blog.mateuszgrabarski.view.database.dao

import androidx.room.Dao
import androidx.room.Insert
import blog.mateuszgrabarski.view.database.entity.CategoryEntity

@Dao
interface CategoryDao {

    @Insert
    suspend fun insert(category: CategoryEntity)
}