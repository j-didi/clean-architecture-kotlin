package usecases.todos.getbyid

import java.util.*

data class GetTodoByIdResult(
    val id: UUID,
    val description: String,
    val done: Boolean
)

