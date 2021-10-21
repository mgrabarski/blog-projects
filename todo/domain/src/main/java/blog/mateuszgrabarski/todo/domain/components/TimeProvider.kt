package blog.mateuszgrabarski.todo.domain.components

import java.util.*

interface TimeProvider {
    fun now(): Date
}