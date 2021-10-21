package blog.mateuszgrabarski.todo.domain.model.data

import java.util.*

data class ToDo(
    val id: String,
    val description: String,
    val comment: String,
    val createdAt: Date,
    val updatedAt: Date,
    val deadline: Date,
    val listId: String,
    val categoryId: String
)