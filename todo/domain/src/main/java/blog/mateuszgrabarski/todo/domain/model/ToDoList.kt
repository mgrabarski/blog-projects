package blog.mateuszgrabarski.todo.domain.model

import java.util.*

data class ToDoList(
    val id: String,
    val title: String,
    val description: String,
    val createDate: Date
)

