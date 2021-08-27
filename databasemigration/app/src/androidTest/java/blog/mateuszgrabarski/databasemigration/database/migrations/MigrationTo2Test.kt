package blog.mateuszgrabarski.databasemigration.database.migrations

import androidx.room.testing.MigrationTestHelper
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import blog.mateuszgrabarski.databasemigration.database.AppDatabase
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MigrationTo2Test {

    @get:Rule
    val testHelper = MigrationTestHelper(
        InstrumentationRegistry.getInstrumentation(),
        AppDatabase::class.java,
        listOf()
    )

    @Test
    fun migrateFrom2To3() {
        preparePreviousVersionOfDatabase()

        val migratedDb = migrateDatabase()
        val cursor = migratedDb.query("SELECT last_name FROM user WHERE id = 1").apply {
            moveToFirst()
        }

        val result = cursor.getString(cursor.getColumnIndex("last_name"))

        assertEquals("", result)
    }

    private fun insertSomeUser(database: SupportSQLiteDatabase) {
        database.execSQL("INSERT INTO user VALUES ('first name', 1)")
    }

    private fun preparePreviousVersionOfDatabase() {
        val database = testHelper.createDatabase(DATABASE_NAME, START_DB_VERSION)
        insertSomeUser(database)
        database.close()
    }

    private fun migrateDatabase() = testHelper.runMigrationsAndValidate(
        DATABASE_NAME,
        FINAL_DB_VERSION,
        true,
        MigrationTo2()
    )

    companion object {
        private const val DATABASE_NAME = "test-database"
        private const val START_DB_VERSION = 1
        private const val FINAL_DB_VERSION = 2
    }
}