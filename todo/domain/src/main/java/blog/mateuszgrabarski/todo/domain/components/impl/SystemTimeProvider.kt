package blog.mateuszgrabarski.todo.domain.components.impl

import blog.mateuszgrabarski.todo.domain.components.TimeProvider
import java.util.*

class SystemTimeProvider : TimeProvider {

    override fun now(): Date = Date(System.currentTimeMillis())
}