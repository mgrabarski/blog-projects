package com.mateuszgrabarski.roomrelation.database.entities.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.mateuszgrabarski.roomrelation.database.entities.Post
import com.mateuszgrabarski.roomrelation.database.entities.User

data class UserAndPosts(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val posts: List<Post>
)