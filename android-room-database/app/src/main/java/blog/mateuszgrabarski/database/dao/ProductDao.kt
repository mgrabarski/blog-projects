package blog.mateuszgrabarski.database.dao

import androidx.room.*
import blog.mateuszgrabarski.database.entities.ProductEntity

@Dao
interface ProductDao {

    @Insert
    fun insert(productEntity: ProductEntity): Long

    @Query("SELECT * FROM product WHERE id = :id")
    fun getById(id: Int): ProductEntity?

    @Update
    fun update(productEntity: ProductEntity)

    @Delete
    fun delete(productEntity: ProductEntity)

    @Query("SELECT * FROM product WHERE name LIKE '%' || :text || '%'")
    fun searchProductsLike(text: String): List<ProductEntity>
}