package blog.mateuszgrabarski.model

import java.time.Instant
import java.util.UUID

typealias Id = UUID

data class Todo(
    val id: Id,
    val title: String,
    val body: String,
    val create: Instant
)