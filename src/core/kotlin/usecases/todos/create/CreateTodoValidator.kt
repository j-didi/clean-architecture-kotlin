package usecases.todos.create

import common.DescriptionRules
import io.konform.validation.Validation
import io.konform.validation.jsonschema.maxLength
import io.konform.validation.jsonschema.minLength
import operationresult.ValidationFail

class CreateTodoValidator {

    fun getFails(command: CreateTodoCommand): List<ValidationFail> {

        return Validation<CreateTodoCommand> {
            CreateTodoCommand::description {
                minLength(DescriptionRules.MIN_LENGTH)
                maxLength(DescriptionRules.MAX_LENGTH)
            }
        }.validate(command).errors.map {
            ValidationFail(it.message, it.dataPath.replace(".", ""))
        }
    }
}

