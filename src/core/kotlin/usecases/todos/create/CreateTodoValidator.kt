package usecases.todos.create

import io.konform.validation.Validation
import io.konform.validation.jsonschema.maxLength
import io.konform.validation.jsonschema.minLength
import operationresult.ValidationFail

class CreateTodoValidator {

    fun getFails(command: CreateTodoCommand): List<ValidationFail> {
        return Validation<CreateTodoCommand> {
            CreateTodoCommand::description {
                minLength(2)
                maxLength(250)
            }
        }.validate(command).errors.map {
            ValidationFail(it.message, it.dataPath.replace(".", ""))
        }
    }
}

