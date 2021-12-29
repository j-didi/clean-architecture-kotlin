package ports

import usecases.todos.Todo
import java.util.*

interface TodoRepository {
    fun save(todo: Todo): UUID
}