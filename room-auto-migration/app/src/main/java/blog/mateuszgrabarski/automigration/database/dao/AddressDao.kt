package blog.mateuszgrabarski.automigration.database.dao

import androidx.room.Dao
import androidx.room.Insert
import blog.mateuszgrabarski.automigration.database.entites.AddressEntity

@Dao
interface AddressDao {

    @Insert
    fun insert(addressEntity: AddressEntity)
}