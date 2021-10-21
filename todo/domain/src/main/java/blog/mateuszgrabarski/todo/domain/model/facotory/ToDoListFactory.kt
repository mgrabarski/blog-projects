package blog.mateuszgrabarski.todo.domain.model.facotory

import blog.mateuszgrabarski.todo.domain.components.TimeProvider
import blog.mateuszgrabarski.todo.domain.model.data.ToDoList
import blog.mateuszgrabarski.todo.domain.model.types.Id

class ToDoListFactory(
    private val timeProvider: TimeProvider
) {

    fun createNewList(title: String, description: String) = ToDoList(
        id = Id.randomUUID(),
        title = title,
        description = description,
        createDate = timeProvider.now()
    )
}