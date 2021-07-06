package blog.mateuszgrabarski.service

import blog.mateuszgrabarski.model.Id
import blog.mateuszgrabarski.model.Todo
import blog.mateuszgrabarski.repository.TodoRepository
import java.time.Instant

class TodoService(
    private val repository: TodoRepository
) {

    fun create(title: String, message: String) = repository.insert(
        Todo(
            id = Id.randomUUID(),
            title = title,
            body = message,
            create = Instant.now()
        )
    )
}