package blog.mateuszgrabarski.databasemigration.database.migrations

import androidx.room.Room
import androidx.room.testing.MigrationTestHelper
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import blog.mateuszgrabarski.databasemigration.database.AppDatabase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AllMigrationsTest {

    @get:Rule
    val testHelper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        AppDatabase::class.java,
        listOf()
    )

    private val migrations = arrayOf(
        MigrationTo2()
    )

    @Test
    fun migrateAll() {
        testHelper.createDatabase(DATABASE_NAME, 1).apply {
            close()
        }

        Room.databaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).addMigrations(*migrations)
            .build().apply {
                openHelper.writableDatabase
                close()
            }
    }

    companion object {
        private const val DATABASE_NAME = "test-database"
    }
}