package blog.mateuszgrabarski.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import blog.mateuszgrabarski.database.ApplicationDatabase
import blog.mateuszgrabarski.database.entities.ProductEntity
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProductDaoTest {

    private val context: Context = ApplicationProvider.getApplicationContext()

    private lateinit var database: ApplicationDatabase
    private lateinit var dao: ProductDao

    @Before
    internal fun setUp() {
        database = Room
            .inMemoryDatabaseBuilder(context, ApplicationDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        dao = database.provideProductDao()
    }

    @Test
    fun `Inserts new product and get it from database`() {
        val product = ProductEntity("name", "createDate", "storeName")
        val productId = dao.insert(product).toInt()

        val productFromDatabase = dao.getById(productId)!!

        assertEquals("name", productFromDatabase.name)
        assertEquals("createDate", productFromDatabase.createDate)
        assertEquals("storeName", productFromDatabase.storeName)
    }

    @Test
    fun `Search product with text in name`() {
        val product1 = ProductEntity("Example1", "createDate", "storeName")
        val product2 = ProductEntity("Example2", "createDate", "storeName")
        val product3 = ProductEntity("name", "createDate", "storeName")
        dao.insert(product1)
        dao.insert(product2)
        val product3Id = dao.insert(product3).toInt()

        val result = dao.searchProductsLike("ame")

        assertEquals(1, result.size)
        assertEquals(product3Id, result[0].id)
    }

    @After
    fun tearDown() {
        database.close()
    }
}