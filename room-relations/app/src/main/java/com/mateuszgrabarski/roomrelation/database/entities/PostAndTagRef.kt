package com.mateuszgrabarski.roomrelation.database.entities

import androidx.room.Entity
import com.mateuszgrabarski.roomrelation.database.types.Id

@Entity(primaryKeys = ["postId", "tagId"])
data class PostAndTagRef(
    val postId: Id,
    val tagId: Id
)