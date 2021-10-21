package blog.mateuszgrabarski.todo.domain.model.facotory

import blog.mateuszgrabarski.todo.domain.components.impl.SystemTimeProvider
import blog.mateuszgrabarski.todo.domain.model.types.Id
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import java.util.*

internal class ToDoFactoryTest {

    private val sut = ToDoFactory(SystemTimeProvider())

    @Test
    internal fun `Creates new todo without deadline`() {
        val description = "description"
        val comment = "comment"
        val listId = Id.randomUUID()
        val categoryId = Id.randomUUID()

        val result = sut.create(description, comment, null, listId, categoryId)

        assertEquals(description, result.description)
        assertEquals(comment, result.comment)
        assertEquals(listId, result.listId)
        assertNull(result.deadline)
        assertEquals(categoryId, result.categoryId)
    }

    @Test
    internal fun `Creates new todo with deadline`() {
        val description = "description"
        val comment = "comment"
        val deadline = Date()
        val listId = Id.randomUUID()
        val categoryId = Id.randomUUID()

        val result = sut.create(description, comment, deadline, listId, categoryId)

        assertEquals(description, result.description)
        assertEquals(comment, result.comment)
        assertEquals(listId, result.listId)
        assertEquals(deadline, result.deadline)
        assertEquals(categoryId, result.categoryId)
    }
}