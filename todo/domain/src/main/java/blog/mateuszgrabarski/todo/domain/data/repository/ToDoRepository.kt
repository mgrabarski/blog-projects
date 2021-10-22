package blog.mateuszgrabarski.todo.domain.data.repository

import blog.mateuszgrabarski.todo.domain.model.ToDo
import blog.mateuszgrabarski.todo.domain.data.types.Id

interface ToDoRepository {
    fun create(todo: ToDo): Id
    fun update(todo: ToDo)
    fun getById(id: Id): ToDo?
    fun delete(todo: ToDo)
}