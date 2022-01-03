package usecases.todos.getbyid

import operationresult.OperationResult
import java.util.*

interface GetTodoByIdHandler {
    fun handle(id: UUID): OperationResult<GetTodoByIdResult>
}
