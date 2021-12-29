package routing

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.getKoin
import usecases.todos.create.CreateTodoCommand
import usecases.todos.create.CreateTodoHandler

fun Route.todoRouting() {

    val createTodoHandler = getKoin().get<CreateTodoHandler>()

    route("todo") {
        post {
            call.receiveOrNull<CreateTodoCommand>().let {

                val operation = createTodoHandler.handle(it!!)

                if(operation.fail) {
                    call.respond(HttpStatusCode.BadRequest, operation.fails)
                }

                call.respond(operation.result!!)
            }

            call.respond(HttpStatusCode.BadRequest)
        }
    }
}