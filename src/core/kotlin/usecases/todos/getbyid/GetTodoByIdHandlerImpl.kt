package usecases.todos.getbyid

import operationresult.OperationResult
import operationresult.notFoundFail
import operationresult.success
import ports.TodoRepository
import java.util.*

class GetTodoByIdHandlerImpl(private val repository: TodoRepository) : GetTodoByIdHandler {

    override fun handle(id: UUID): OperationResult<GetTodoByIdResult> {

        val todo = repository.getById(id) ?:
            return notFoundFail()

        val result = GetTodoByIdResult(todo.id, todo.description, todo.done)
        return success(result)
    }
}

