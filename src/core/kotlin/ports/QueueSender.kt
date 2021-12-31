package ports

import usecases.todos.Todo

interface QueueSender {
    fun send(todo: Todo)
}