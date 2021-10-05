package blog.mateuszgrabarski.databaseindex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import blog.mateuszgrabarski.databaseindex.data.InsertRandomData
import blog.mateuszgrabarski.databaseindex.data.PolishNamesFileReader
import blog.mateuszgrabarski.databaseindex.data.generator.DataGenerator
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
            InsertRandomData(
                fakeDataGenerator = DataGenerator(PolishNamesFileReader(assets))
            ).generateAndInsertRandomData(
                numberOfMillions = 10,
                userDao = (application as App).provideUserDao()
            )
        }
    }
}

