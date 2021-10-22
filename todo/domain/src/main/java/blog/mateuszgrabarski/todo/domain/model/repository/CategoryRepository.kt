package blog.mateuszgrabarski.todo.domain.model.repository

import blog.mateuszgrabarski.todo.domain.model.data.Category
import blog.mateuszgrabarski.todo.domain.model.types.Id

interface CategoryRepository {
    fun create(category: Category): Id
    fun update(category: Category)
    fun getById(id: Id): Category?
    fun delete(category: Category)
}