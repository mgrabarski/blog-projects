package blog.mateuszgrabarski.todo.domain.model.facotory

import blog.mateuszgrabarski.todo.domain.components.TimeProvider
import blog.mateuszgrabarski.todo.domain.model.data.ToDo
import blog.mateuszgrabarski.todo.domain.model.types.Id
import java.util.Date

class ToDoFactory(
    private val timeProvider: TimeProvider
) {

    fun create(description: String, comment: String, deadline: Date?, listId: Id, categoryId: Id) =
        ToDo(
            id = Id.randomUUID(),
            description = description,
            comment = comment,
            createdAt = timeProvider.now(),
            updatedAt = Date(0),
            deadline = deadline,
            listId = listId,
            categoryId = categoryId
        )
}