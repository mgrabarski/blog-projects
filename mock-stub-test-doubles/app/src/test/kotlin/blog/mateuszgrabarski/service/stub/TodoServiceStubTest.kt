package blog.mateuszgrabarski.service.stub

import blog.mateuszgrabarski.service.TodoService
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TodoServiceStubTest {

    private val repository = TodoRepositoryFake()
    private val sut = TodoService(repository)

    @Test
    internal fun `Inserts todo`() {
        val id = sut.create(SOME_TITLE, SOME_BODY)

        val result = repository.getById(id)!!

        assertEquals(SOME_TITLE, result.title)
        assertEquals(SOME_BODY, result.body)
    }

    companion object {
        private const val SOME_TITLE = "title"
        private const val SOME_BODY = "body"
    }
}