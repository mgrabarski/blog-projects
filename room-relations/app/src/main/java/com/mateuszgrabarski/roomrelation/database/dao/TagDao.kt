package com.mateuszgrabarski.roomrelation.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.mateuszgrabarski.roomrelation.database.entities.Post
import com.mateuszgrabarski.roomrelation.database.entities.PostAndTagRef
import com.mateuszgrabarski.roomrelation.database.entities.Tag
import com.mateuszgrabarski.roomrelation.database.entities.relation.PostAndTag

@Dao
interface TagDao {

    @Insert
    suspend fun insert(tag: Tag)

    @Insert
    suspend fun insert(join: PostAndTagRef)

    @Transaction
    @Query("SELECT * FROM Post WHERE id = :postId")
    suspend fun getPostWithTags(postId: String): PostAndTag

    @Transaction
    @Query(
        "SELECT * FROM Post " +
                "JOIN PostAndTagRef ON PostAndTagRef.postId = Post.id " +
                "JOIN Tag ON Tag.id = PostAndTagRef.tagId " +
                "WHERE Post.id = :postId"
    )
    suspend fun getPostWithTagsMultimap(postId: String): Map<Post, List<Tag>>
}