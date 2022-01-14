package com.mateuszgrabarski.roomrelation.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.mateuszgrabarski.roomrelation.database.entities.IdentificationCard
import com.mateuszgrabarski.roomrelation.database.entities.User
import com.mateuszgrabarski.roomrelation.database.entities.relation.UserAndIdentificationCard

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Transaction
    @Query("SELECT * FROM User WHERE id = :userId")
    suspend fun getUserWithIdentificationCard(userId: String): UserAndIdentificationCard


    @Transaction
    @Query("SELECT * FROM User JOIN IdentificationCard ON User.id = IdentificationCard.userId WHERE User.id = :userId")
    suspend fun getUserWithIdentificationCardMultimap(userId: String): Map<User, IdentificationCard>
}