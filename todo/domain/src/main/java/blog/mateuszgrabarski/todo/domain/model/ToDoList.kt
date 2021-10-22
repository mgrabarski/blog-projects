package blog.mateuszgrabarski.todo.domain.model

import blog.mateuszgrabarski.todo.domain.data.types.Id
import java.util.*

data class ToDoList(
    val id: Id,
    val title: String,
    val description: String,
    val createDate: Date
)

