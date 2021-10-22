package blog.mateuszgrabarski.todo.domain.data.repository

import blog.mateuszgrabarski.todo.domain.model.ToDoList
import blog.mateuszgrabarski.todo.domain.data.types.Id

interface ToDoListRepository {
    fun create(toDoList: ToDoList): Id
    fun update(toDoList: ToDoList)
    fun getById(id: Id): ToDoList?
    fun delete(toDoList: ToDoList)
}