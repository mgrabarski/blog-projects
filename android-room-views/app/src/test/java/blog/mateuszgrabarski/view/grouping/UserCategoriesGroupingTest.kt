package blog.mateuszgrabarski.view.grouping

import blog.mateuszgrabarski.view.database.views.Category
import blog.mateuszgrabarski.view.database.views.Subcategory
import blog.mateuszgrabarski.view.database.views.UserCategories
import org.junit.Assert.assertEquals
import org.junit.Test

class UserCategoriesGroupingTest {

    private val sut = UserCategoriesGrouping()

    @Test
    fun `Groups user categories`() {
        val breadLight = UserCategories(ANY_USER_ID, BREAD_CATEGORY, BREAD_LIGHT)
        val breadDark = UserCategories(ANY_USER_ID, BREAD_CATEGORY, BREAD_DARK)

        val result = sut.group(listOf(breadLight, breadDark))

        assertEquals(result.size, 1)
        assertEquals(listOf(BREAD_LIGHT, BREAD_DARK), result[BREAD_CATEGORY])
    }

    companion object {
        private const val ANY_USER_ID = "1"
        private val BREAD_CATEGORY = Category("1", "Bread")
        private val BREAD_LIGHT = Subcategory("1", "Light")
        private val BREAD_DARK = Subcategory("2", "Dark")
    }
}