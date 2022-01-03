package usecases.todos.create

import operationresult.OperationResult
import operationresult.success
import operationresult.validationFail
import ports.TodoRepository
import usecases.todos.Todo

class CreateTodoHandlerImpl(
    private val repository: TodoRepository,
    private val validator: CreateTodoValidator
) : CreateTodoHandler {

    override fun handle(command: CreateTodoCommand): OperationResult<CreateTodoResult> {

        val fails = validator.getFails(command)

        if(fails.any()) {
            return validationFail(fails)
        }

        val todo = Todo(command.description)
        repository.save(todo)
        return success(CreateTodoResult(todo.id))
    }
}
