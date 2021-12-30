package usecases.todos.markasdone

import operationresult.EmptyResult
import operationresult.OperationResult
import operationresult.notFoundFail
import operationresult.success
import ports.TodoRepository
import java.util.*

class MarkTodoAsDoneHandlerImpl(private val repository: TodoRepository) : MarkTodoAsDoneHandler {

    override fun handle(id: UUID): OperationResult<EmptyResult> {
        val todo = repository.getById(id) ?:
            return notFoundFail()

        repository.markAsDone(todo)
        return success()
    }

}