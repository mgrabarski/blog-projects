package com.mateuszgrabarski.roomrelation.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.mateuszgrabarski.roomrelation.database.entities.Post
import com.mateuszgrabarski.roomrelation.database.entities.User
import com.mateuszgrabarski.roomrelation.database.entities.relation.UserAndPosts

@Dao
interface PostsDao {

    @Insert
    suspend fun insert(post: Post)

    @Transaction
    @Query("SELECT * FROM User WHERE id = :userId")
    suspend fun getUserPosts(userId: String): UserAndPosts

    @Transaction
    @Query("SELECT * FROM User JOIN Post ON User.id = Post.userId WHERE User.id = :userId")
    suspend fun getUserPostsMultimap(userId: String): Map<User, List<Post>>
}