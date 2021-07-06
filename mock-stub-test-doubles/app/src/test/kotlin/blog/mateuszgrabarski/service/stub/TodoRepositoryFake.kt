package blog.mateuszgrabarski.service.stub

import blog.mateuszgrabarski.model.Id
import blog.mateuszgrabarski.model.Todo
import blog.mateuszgrabarski.repository.TodoRepository

class TodoRepositoryFake : TodoRepository {

    private val map = mutableMapOf<Id, Todo>()

    override fun insert(todo: Todo): Id {
        map[todo.id] = todo
        return todo.id
    }

    override fun getById(id: Id): Todo? = map[id]
}