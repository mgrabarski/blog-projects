package blog.mateuszgrabarski.view.grouping

import blog.mateuszgrabarski.view.database.views.Category
import blog.mateuszgrabarski.view.database.views.Subcategory
import blog.mateuszgrabarski.view.database.views.UserCategories

class UserCategoriesGrouping {

    fun group(categories: List<UserCategories>): MutableMap<Category, List<Subcategory>> {
        val keys = categories.map { it.category }
        val map = mutableMapOf<Category, List<Subcategory>>()
        keys.forEach { key ->
            val filteredCategories = categories.filter { it.category == key }
            map[key] = filteredCategories.map { it.subcategory }
        }
        return map
    }
}