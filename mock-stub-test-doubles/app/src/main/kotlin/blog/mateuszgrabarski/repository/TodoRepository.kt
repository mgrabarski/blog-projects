package blog.mateuszgrabarski.repository

import blog.mateuszgrabarski.model.Id
import blog.mateuszgrabarski.model.Todo

interface TodoRepository {
    fun insert(todo: Todo): Id
    fun getById(id: Id): Todo?
}