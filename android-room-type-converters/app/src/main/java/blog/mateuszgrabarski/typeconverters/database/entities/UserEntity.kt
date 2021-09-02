package blog.mateuszgrabarski.typeconverters.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import blog.mateuszgrabarski.typeconverters.database.types.Avatar
import blog.mateuszgrabarski.typeconverters.database.types.LocalId
import blog.mateuszgrabarski.typeconverters.database.types.ServerId
import java.util.Date

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: LocalId,
    @ColumnInfo(name = "server_id")
    val serverId: ServerId,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "create_date")
    val createDate: Date,
    @ColumnInfo(name = "avatar")
    val avatar: Avatar
)