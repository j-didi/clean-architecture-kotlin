package usecases.todos.markasdone

import operationresult.EmptyResult
import operationresult.OperationResult
import operationresult.notFoundFail
import operationresult.success
import ports.QueueSender
import ports.TodoRepository
import java.util.*

class MarkTodoAsDoneHandlerImpl(
    private val repository: TodoRepository,
    private val queueSender: QueueSender
) : MarkTodoAsDoneHandler {

    override fun handle(id: UUID): OperationResult<EmptyResult> {
        val todo = repository.getById(id) ?:
            return notFoundFail()

        repository.markAsDone(todo)
        queueSender.send(todo)
        return success()
    }

}
