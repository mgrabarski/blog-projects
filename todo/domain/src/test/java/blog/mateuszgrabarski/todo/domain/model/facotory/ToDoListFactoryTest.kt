package blog.mateuszgrabarski.todo.domain.model.facotory

import blog.mateuszgrabarski.todo.domain.components.impl.SystemTimeProvider
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ToDoListFactoryTest {

    private val timeProvider = SystemTimeProvider()
    private val sut = ToDoListFactory(timeProvider)

    @Test
    internal fun `Creates new todo list`() {
        val title = "title"
        val description = "description"

        val result = sut.createNewList(title, description)

        assertEquals(title, result.title)
        assertEquals(description, result.description)
    }
}