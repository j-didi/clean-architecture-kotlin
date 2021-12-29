package plugins

import routing.todoRouting
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        todoRouting()
    }
}


