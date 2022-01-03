package routing

import common.respondOperation
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receiveOrNull
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.route
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import io.ktor.server.routing.delete
import org.koin.java.KoinJavaComponent.getKoin
import usecases.todos.create.CreateTodoCommand
import usecases.todos.create.CreateTodoHandler
import usecases.todos.delete.DeleteTodoHandler
import usecases.todos.get.GetTodosHandler
import usecases.todos.getbyid.GetTodoByIdHandler
import usecases.todos.markasdone.MarkTodoAsDoneHandler
import java.util.*

fun Route.todoRouting() {

    val getTodosHandler = getKoin().get<GetTodosHandler>()
    val getTodosByIdHandler = getKoin().get<GetTodoByIdHandler>()
    val createTodoHandler = getKoin().get<CreateTodoHandler>()
    val markTodoAsDoneHandler = getKoin().get<MarkTodoAsDoneHandler>()
    val deleteTodoHandler = getKoin().get<DeleteTodoHandler>()


    route("todo") {
        get {
            call.respond(getTodosHandler.handle())
        }
        get("{id}") {

            val id = call.parameters["id"]

            if(id == null) {
                call.respond(HttpStatusCode.BadRequest)
            }

            val operation = getTodosByIdHandler.handle(UUID.fromString(id))
            call.respondOperation(operation)

        }
        post {

            val command = call.receiveOrNull<CreateTodoCommand>()

            if(command == null) {
                call.respond(HttpStatusCode.BadRequest)
            }

            val operation = createTodoHandler.handle(command!!)
            call.respondOperation(operation)

        }
        put("{id}/mark-as-done") {
            val id = call.parameters["id"]

            if(id == null) {
                call.respond(HttpStatusCode.BadRequest)
            }

            val operation = markTodoAsDoneHandler.handle(UUID.fromString(id))
            call.respondOperation(operation)
        }

        delete("{id}") {
            val id = call.parameters["id"]

            if(id == null) {
                call.respond(HttpStatusCode.BadRequest)
            }

            val operation = deleteTodoHandler.handle(UUID.fromString(id))
            call.respondOperation(operation)
        }
    }
}

