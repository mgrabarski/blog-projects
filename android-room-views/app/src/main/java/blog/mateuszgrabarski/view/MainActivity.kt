package blog.mateuszgrabarski.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import blog.mateuszgrabarski.view.database.entity.CategoryEntity
import blog.mateuszgrabarski.view.database.entity.SubcategoryEntity
import blog.mateuszgrabarski.view.database.entity.UserEntity
import blog.mateuszgrabarski.view.grouping.UserCategoriesGrouping
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {

    private val scope = CoroutineScope(EmptyCoroutineContext + Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scope.launch {
            val userDao = (application as App).provideUserDao()
            val userToInsert =
                UserEntity(UUID.randomUUID().toString(), "name", "last name", "password")

            userDao.insert(userToInsert)

            val viewDao = (application as App).provideViewDao()
            Log.d("MainActivity", "onCreate: ${viewDao.getUser(userToInsert.id)}")

            val category = CategoryEntity(UUID.randomUUID().toString(), "Bread", userToInsert.id)
            (application as App).provideCategoryDao().insert(category)

            val lightBread = SubcategoryEntity(UUID.randomUUID().toString(), "Light", category.id)
            val darkBread = SubcategoryEntity(UUID.randomUUID().toString(), "Dark", category.id)

            (application as App).provideSubcategoryDao().insert(lightBread, darkBread)

            val userCategoryViewDao = (application as App).provideUserCategoryViewDao()
            val userCategories = userCategoryViewDao.getUserCategories(userToInsert.id)
            Log.d("MainActivity", "onCreate: $userCategories")

            UserCategoriesGrouping().group(userCategories)
        }
    }
}