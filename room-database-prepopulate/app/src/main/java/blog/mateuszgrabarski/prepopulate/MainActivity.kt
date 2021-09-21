package blog.mateuszgrabarski.prepopulate

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import blog.mateuszgrabarski.prepopulate.database.AppDatabase
import blog.mateuszgrabarski.prepopulate.database.entities.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.coroutines.EmptyCoroutineContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}