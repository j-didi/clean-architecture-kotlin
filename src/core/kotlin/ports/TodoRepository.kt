package ports

import usecases.todos.Todo
import java.util.*

interface TodoRepository {
    fun get(): List<Todo>
    fun getById(id: UUID): Todo?
    fun save(todo: Todo)
    fun delete(todo: Todo)
    fun markAsDone(todo: Todo)
}