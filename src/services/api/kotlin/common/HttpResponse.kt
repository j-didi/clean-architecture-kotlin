package common

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import operationresult.EmptyResult
import operationresult.FailValidationType
import operationresult.OperationResult

suspend fun ApplicationCall.respondOperation(operation: OperationResult<*>) {

    val fails = operation.fails

    if(fails.any { it.type == FailValidationType.NotFound }) {
        respond(HttpStatusCode.NotFound)
    }

    if(fails.isNotEmpty()) {
        respond(HttpStatusCode.BadRequest, fails)
    }

    if(operation.result == null || operation.result is EmptyResult) {
        respond(HttpStatusCode.OK)
    }

    respond(operation.result!!)
}