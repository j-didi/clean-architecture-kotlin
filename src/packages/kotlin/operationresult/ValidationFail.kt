package operationresult

data class ValidationFail(
    val description: String,
    val field: String = "default",
    val type: FailValidationType
) {
    constructor(description: String, field: String)
        : this(description, field, FailValidationType.FailValidation)
}

