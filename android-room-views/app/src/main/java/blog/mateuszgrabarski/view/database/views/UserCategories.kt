package blog.mateuszgrabarski.view.database.views

import androidx.room.ColumnInfo
import androidx.room.DatabaseView
import androidx.room.Embedded

@DatabaseView(
    viewName = "user_categories",
    value = "SELECT " +
            "user.id AS user_id, " +
            "category.id AS category_id, " +
            "category.name AS category_name, " +
            "subcategory.id AS subcategory_id, " +
            "subcategory.name AS subcategory_name " +
            "FROM user " +
            "INNER JOIN category ON user.id = category.user_id " +
            "INNER JOIN subcategory ON category.id = subcategory.category_id"
)
data class UserCategories(
    @ColumnInfo(name = "user_id")
    val userId: String,
    @Embedded
    val category: Category,
    @Embedded
    val subcategory: Subcategory
)

data class Category(
    @ColumnInfo(name = "category_id")
    val id: String,
    @ColumnInfo(name = "category_name")
    val name: String
)

data class Subcategory(
    @ColumnInfo(name = "subcategory_id")
    val id: String,
    @ColumnInfo(name = "subcategory_name")
    val name: String
)