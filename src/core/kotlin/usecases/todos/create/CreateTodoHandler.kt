package usecases.todos.create

import operationresult.OperationResult

interface CreateTodoHandler {
    fun handle(command: CreateTodoCommand): OperationResult<CreateTodoResult>
}