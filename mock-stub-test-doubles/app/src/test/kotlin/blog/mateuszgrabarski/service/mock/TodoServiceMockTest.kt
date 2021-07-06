package blog.mateuszgrabarski.service.mock

import blog.mateuszgrabarski.model.Id
import blog.mateuszgrabarski.model.Todo
import blog.mateuszgrabarski.repository.TodoRepository
import blog.mateuszgrabarski.service.TodoService
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class TodoServiceMockTest {

    private val repository = mockk<TodoRepository>()
    private val sut = TodoService(repository)

    private val slot = slot<Todo>()

    @Test
    internal fun `Inserts new todo in mock object`() {
        every { repository.insert(capture(slot)) } returns ANY_ID

        val result = sut.create(SOME_TITLE, SOME_BODY)

        verify(exactly = 1) { repository.insert(any()) }
        assertEquals(ANY_ID, result)
        assertEquals(SOME_TITLE, slot.captured.title)
        assertEquals(SOME_BODY, slot.captured.body)
    }

    companion object {
        private val ANY_ID = Id.randomUUID()
        private const val SOME_TITLE = "title"
        private const val SOME_BODY = "body"
    }
}