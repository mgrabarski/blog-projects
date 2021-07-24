package blog.mateuszgrabarski.database.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class MigrationFrom2To3 : Migration(2, 3) {

    override fun migrate(database: SupportSQLiteDatabase) {
        val addColumnSQL = "ALTER TABLE product ADD COLUMN available_number INTEGER NOT NULL DEFAULT 0"
        database.execSQL(addColumnSQL)
    }
}