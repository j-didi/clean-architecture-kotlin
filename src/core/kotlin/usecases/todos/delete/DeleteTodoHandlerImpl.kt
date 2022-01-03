package usecases.todos.delete

import operationresult.EmptyResult
import operationresult.OperationResult
import operationresult.notFoundFail
import operationresult.success
import ports.TodoRepository
import java.util.*

class DeleteTodoHandlerImpl(private val repository: TodoRepository) : DeleteTodoHandler {

    override fun handle(id: UUID): OperationResult<EmptyResult> {

        val todo = repository.getById(id) ?:
            return notFoundFail()

        repository.delete(todo)
        return success()
    }
}
