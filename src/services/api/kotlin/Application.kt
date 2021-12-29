import io.ktor.server.engine.*
import io.ktor.server.netty.*
import plugins.configureDependencies
import plugins.configureRouting
import plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080, host = "localhost") {
        configureSerialization()
        configureDependencies()
        configureRouting()
    }.start(wait = true)
}
