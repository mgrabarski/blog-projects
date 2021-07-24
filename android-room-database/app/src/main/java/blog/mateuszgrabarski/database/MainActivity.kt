package blog.mateuszgrabarski.database

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import blog.mateuszgrabarski.database.databinding.ActivityMainBinding
import blog.mateuszgrabarski.database.entities.ProductEntity
import kotlinx.coroutines.*

@DelicateCoroutinesApi
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch(Dispatchers.IO) {
            delay(100)
            val product = ProductEntity("product name", "some create date", "store name", "", 0)

            val productDao = (application as App).providesProductDao()

            // Insert
            val productId = productDao.insert(product)
            Log.d("MainActivity", "onCreate: $productId")

            // Get
            val productFromDatabase = productDao.getById(productId.toInt())

            // Update
            productFromDatabase?.let {
                it.name = "updated name"
                productDao.update(it)
            }

            // Delete
            productFromDatabase?.let {
                productDao.delete(it)
            }
        }
    }
}