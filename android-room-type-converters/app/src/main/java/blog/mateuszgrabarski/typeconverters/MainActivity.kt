package blog.mateuszgrabarski.typeconverters

import android.graphics.Bitmap.Config.ARGB_8888
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import blog.mateuszgrabarski.typeconverters.database.entities.UserEntity
import blog.mateuszgrabarski.typeconverters.database.types.Avatar
import blog.mateuszgrabarski.typeconverters.database.types.LocalId
import blog.mateuszgrabarski.typeconverters.database.types.ServerId
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
            // Get DAO from application
            val dao = (application as App).provideUserDao()

            // Declare user entity to insert
            val user = UserEntity(
                id = LocalId.randomUUID(),
                serverId = ServerId.randomUUID(),
                name = "name",
                createDate = Date(),
                avatar = Avatar.createBitmap(10, 10, ARGB_8888)
            )

            // Insert new user to database
            dao.insert(user)

            // Get user from database
            val userFromDatabase = dao.getById(user.id)

            Log.d("MainActivity", "onCreate: $userFromDatabase")
        }
    }
}