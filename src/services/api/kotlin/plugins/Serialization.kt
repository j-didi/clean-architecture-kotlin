package plugins

import io.ktor.serialization.gson.gson
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.ContentNegotiation

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        gson()
    }
}

