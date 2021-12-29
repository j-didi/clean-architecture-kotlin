package usecases.todos

import java.util.*

class Todo(
    val id: UUID,
    val description: String,
    val done: Boolean
) {
    constructor(description: String):
            this(UUID.randomUUID(), description, false)
}