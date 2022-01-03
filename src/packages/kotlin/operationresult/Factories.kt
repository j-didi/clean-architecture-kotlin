package operationresult

fun <T>success(result: T): OperationResult<T> =
    OperationResult(result = result)

fun success(): OperationResult<EmptyResult> =
    OperationResult(result = EmptyResult())

fun <T>validationFail(fails: List<ValidationFail>): OperationResult<T> {
    return OperationResult(fails = fails)
}

fun <T>notFoundFail(description: String = "Not Found!"): OperationResult<T> {
    val validation = ValidationFail(description, type = FailValidationType.NotFound)
    return OperationResult(fails = listOf(validation))
}
