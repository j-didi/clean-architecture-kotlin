package usecases.todos.get

import ports.TodoRepository

class GetTodosHandlerImpl(private val repository: TodoRepository) : GetTodosHandler {

    override fun handle(): GetTodosResult {
        val items = repository.get().map {
            GetTodosResult.GetTodosItemResult(it.id, it.description, it.done)
        }

        return GetTodosResult(items)
    }

}