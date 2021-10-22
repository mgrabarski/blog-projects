package blog.mateuszgrabarski.todo.domain.model.repository

import blog.mateuszgrabarski.todo.domain.model.data.ToDoList
import blog.mateuszgrabarski.todo.domain.model.types.Id

interface ToDoListRepository {
    fun create(toDoList: ToDoList): Id
    fun update(toDoList: ToDoList)
    fun getById(id: Id): ToDoList?
    fun delete(toDoList: ToDoList)
}