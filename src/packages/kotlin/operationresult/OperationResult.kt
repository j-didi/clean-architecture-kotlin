package operationresult

class OperationResult<T>(
    val success: Boolean,
    val fails: List<ValidationFail> = mutableListOf(),
    val result: T? = null
) {
    val fail: Boolean
        get() = !success
}