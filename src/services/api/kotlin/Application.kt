import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import plugins.configureDatabase
import plugins.configureDependencies
import plugins.configureRouting
import plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 4500) {
        configureDatabase()
        configureSerialization()
        configureDependencies()
        configureRouting()
    }.start(wait = true)
}
