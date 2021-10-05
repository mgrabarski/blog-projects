package blog.mateuszgrabarski.databaseindex.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

const val TABLE_USER = "user"
const val TABLE_USER_NAME = "name"

@Entity(
    tableName = TABLE_USER,
    indices = [
        Index(TABLE_USER_NAME)
    ]
)
data class UserEntity(
    @ColumnInfo(name = TABLE_USER_NAME)
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}