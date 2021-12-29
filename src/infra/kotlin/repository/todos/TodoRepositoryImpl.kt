package repository.todos

import org.ktorm.database.Database
import org.ktorm.entity.add
import ports.TodoRepository
import usecases.todos.Todo
import java.util.*

internal class TodoRepositoryImpl(database: Database): TodoRepository {

    private val todos = database.todos

    override fun save(todo: Todo): UUID {
        val entity = TodoEntity {
            id = todo.id
            description = todo.description
            done = todo.done
        }
        todos.add(entity)

        return entity.id
    }
}