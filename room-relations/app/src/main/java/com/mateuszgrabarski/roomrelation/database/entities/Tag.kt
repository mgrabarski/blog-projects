package com.mateuszgrabarski.roomrelation.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mateuszgrabarski.roomrelation.database.types.Id

@Entity
data class Tag(
    @PrimaryKey
    val id: Id,
    val name: String
)