package blog.mateuszgrabarski.view.database.dao

import androidx.room.Dao
import androidx.room.Insert
import blog.mateuszgrabarski.view.database.entity.SubcategoryEntity

@Dao
interface SubcategoryDao {

    @Insert
    suspend fun insert(vararg subcategory: SubcategoryEntity)
}