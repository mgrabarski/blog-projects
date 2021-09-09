package blog.mateuszgrabarski.view.database.views

import androidx.room.ColumnInfo
import androidx.room.DatabaseView

@DatabaseView(
    viewName = "user_details",
    value = "SELECT id, name, last_name FROM user"
)
data class UserDetails(
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
)