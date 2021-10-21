package blog.mateuszgrabarski.todo.domain.model.data

import java.util.*

data class ToDoList(
    val id: String,
    val title: String,
    val description: String,
    val createDate: Date
)

