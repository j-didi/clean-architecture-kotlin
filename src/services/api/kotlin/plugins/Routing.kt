package plugins

import routing.todoRouting
import io.ktor.server.application.Application
import io.ktor.server.routing.routing

fun Application.configureRouting() {
    routing {
        todoRouting()
    }
}


