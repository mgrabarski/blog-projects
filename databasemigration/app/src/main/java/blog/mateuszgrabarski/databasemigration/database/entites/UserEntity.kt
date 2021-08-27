package blog.mateuszgrabarski.databasemigration.database.entites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name", defaultValue = "")
    val lastName: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}