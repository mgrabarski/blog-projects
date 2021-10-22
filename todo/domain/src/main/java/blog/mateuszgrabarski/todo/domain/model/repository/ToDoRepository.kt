package blog.mateuszgrabarski.todo.domain.model.repository

import blog.mateuszgrabarski.todo.domain.model.data.ToDo
import blog.mateuszgrabarski.todo.domain.model.types.Id

interface ToDoRepository {
    fun create(todo: ToDo): Id
    fun update(todo: ToDo)
    fun getById(id: Id): ToDo?
    fun delete(todo: ToDo)
}