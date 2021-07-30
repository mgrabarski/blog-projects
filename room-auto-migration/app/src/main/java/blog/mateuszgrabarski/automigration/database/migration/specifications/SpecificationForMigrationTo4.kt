package blog.mateuszgrabarski.automigration.database.migration.specifications

import androidx.room.RenameTable
import androidx.room.migration.AutoMigrationSpec

@RenameTable(fromTableName = "address", toTableName = "user_address")
class SpecificationForMigrationTo4 : AutoMigrationSpec