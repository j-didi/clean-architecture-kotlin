package usecases.todos.markasdone

import operationresult.EmptyResult
import operationresult.OperationResult
import java.util.*

interface MarkTodoAsDoneHandler {
    fun handle(id: UUID): OperationResult<EmptyResult>
}
