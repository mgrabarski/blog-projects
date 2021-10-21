package blog.mateuszgrabarski.todo.domain.model.data

import blog.mateuszgrabarski.todo.domain.model.types.Id
import java.util.*

data class ToDoList(
    val id: Id,
    val title: String,
    val description: String,
    val createDate: Date
)

