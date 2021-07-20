package blog.mateuszgrabarski.gradle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate: ${BuildConfig.VERSION_NAME}")

        getString(R.string.app_name)

        Log.d("MainActivity", "onCreate: ${BuildConfig.CONFIG.apiUrl}")
    }
}