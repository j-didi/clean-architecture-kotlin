package usecases.todos.get

import java.util.*

data class GetTodosResult(
    val items: List<GetTodosItemResult>
) {
    data class GetTodosItemResult(
        val id: UUID,
        val description: String,
        val done: Boolean
    )
}
