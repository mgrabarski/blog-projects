package com.mateuszgrabarski.roomrelation.database.entities.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.mateuszgrabarski.roomrelation.database.entities.Post
import com.mateuszgrabarski.roomrelation.database.entities.PostAndTagRef
import com.mateuszgrabarski.roomrelation.database.entities.Tag

data class PostAndTag(
    @Embedded
    val post: Post,
    @Relation(
        entity = Tag::class,
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = PostAndTagRef::class,
            parentColumn = "postId",
            entityColumn = "tagId"
        )
    )
    val tags: List<Tag>
)