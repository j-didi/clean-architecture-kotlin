package usecases.todos.delete

import operationresult.EmptyResult
import operationresult.OperationResult
import java.util.*

interface DeleteTodoHandler {
    fun handle(id: UUID): OperationResult<EmptyResult>
}