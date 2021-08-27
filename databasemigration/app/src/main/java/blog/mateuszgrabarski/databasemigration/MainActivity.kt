package blog.mateuszgrabarski.databasemigration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import blog.mateuszgrabarski.databasemigration.database.entites.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {

    private val scope = CoroutineScope(EmptyCoroutineContext + Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scope.launch {
            val dao = (application as App).provideUserDao()

            dao.insert(UserEntity("some name", "last name"))
        }
    }
}