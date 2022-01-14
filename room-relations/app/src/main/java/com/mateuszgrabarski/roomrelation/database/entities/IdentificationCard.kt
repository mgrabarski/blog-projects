package com.mateuszgrabarski.roomrelation.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.mateuszgrabarski.roomrelation.database.types.Id

@Entity(
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"]
    )],
    indices = [Index(value = ["userId"])]
)
data class IdentificationCard(
    @PrimaryKey
    val id: Id,
    val pesel: String,
    val identificationCardNumber: String,
    val userId: Id
)