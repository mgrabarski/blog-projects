package blog.mateuszgrabarski.todo.domain.model

import blog.mateuszgrabarski.todo.domain.data.types.Id
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