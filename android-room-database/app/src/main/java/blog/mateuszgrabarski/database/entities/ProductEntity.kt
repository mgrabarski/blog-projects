package blog.mateuszgrabarski.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "create_date")
    val createDate: String,
    @ColumnInfo(name = "store_name")
    val storeName: String,
    @ColumnInfo(name = "price", defaultValue = "")
    val price: String,
    @ColumnInfo(name = "available_number")
    val availableNumber: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}