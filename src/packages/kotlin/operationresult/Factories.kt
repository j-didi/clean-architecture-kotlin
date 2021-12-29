package operationresult

fun <T>success(result: T): OperationResult<T> =
    OperationResult(true, result = result)

fun <T>validationFail(fails: List<ValidationFail>): OperationResult<T> {
    return OperationResult(true, fails = fails)
}

fun notFoundFail(description: String = "Not Found!"): OperationResult<Any> {
    val validation = ValidationFail(description, type = FailValidationType.NotFound)
    return OperationResult(true, fails = listOf(validation))
}