package operationresult

class OperationResult<T>(
    val fails: List<ValidationFail> = mutableListOf(),
    val result: T? = null
)