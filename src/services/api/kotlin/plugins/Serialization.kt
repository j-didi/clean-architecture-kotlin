package plugins

import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gson()
    }
}

