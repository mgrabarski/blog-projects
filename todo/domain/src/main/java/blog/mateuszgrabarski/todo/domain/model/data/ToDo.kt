package blog.mateuszgrabarski.todo.domain.model.data

import blog.mateuszgrabarski.todo.domain.model.types.Id
import java.util.*

data class ToDo(
    val id: Id,
    val description: String,
    val comment: String,
    val createdAt: Date,
    val updatedAt: Date,
    val deadline: Date?,
    val listId: Id,
    val categoryId: Id
)