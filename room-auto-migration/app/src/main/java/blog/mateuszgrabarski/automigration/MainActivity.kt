package blog.mateuszgrabarski.automigration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import blog.mateuszgrabarski.automigration.database.entites.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {

    private val context = CoroutineScope(EmptyCoroutineContext)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context.launch(Dispatchers.IO) {
            val dao = (application as App).getUserDao()

            dao.insert(UserEntity(UUID.randomUUID().toString(), "first2", "last2", 18))
        }
    }
}