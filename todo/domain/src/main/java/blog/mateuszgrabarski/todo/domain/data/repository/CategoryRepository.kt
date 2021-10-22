package blog.mateuszgrabarski.todo.domain.data.repository

import blog.mateuszgrabarski.todo.domain.model.Category
import blog.mateuszgrabarski.todo.domain.data.types.Id

interface CategoryRepository {
    fun create(category: Category): Id
    fun update(category: Category)
    fun getById(id: Id): Category?
    fun delete(category: Category)
}