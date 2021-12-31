import com.rabbitmq.client.*
import java.io.IOException
import java.nio.charset.StandardCharsets


private const val queue: String = "todo"
private const val tag = "Notifier"
private var factory: ConnectionFactory = ConnectionFactory()
private lateinit var connection: Connection
private lateinit var channel: Channel

fun main() {
    connect()
}

fun connect() {

    print("LETS GO!")

    factory.host = "host.docker.internal"
    factory.username = "user1"
    factory.password = "pass1"
    factory.virtualHost = "didi"
    factory.port = 5672
    factory.networkRecoveryInterval = 5000
    factory.requestedHeartbeat = 30

    try {
        connection = factory.newConnection()
        connection.addShutdownListener(shutdownListener())

        channel = connection.createChannel()
        channel.queueDeclare(queue, false, false, false, null)

        val deliverCallback = DeliverCallback { _: String?, delivery: Delivery ->
            val message = String(
                bytes = delivery.body,
                charset = StandardCharsets.UTF_8
            )
            println("[$tag] Received message: '$message'")
        }
        val cancelCallback = CancelCallback { println("[$it] was canceled") }
        channel.basicConsume(queue, true, tag, deliverCallback, cancelCallback)
    } catch (ex: Exception) {
        Thread.sleep(3000)
        connect()
    }
}

private fun shutdownListener(): (cause: ShutdownSignalException) -> Unit = {
    println("Connection broke!")
    reconnect()
}

fun cleanup() {
    try {
        if (channel.isOpen) {
            channel.close()
        }
        if (connection.isOpen) {
            connection.close()
        }
    } catch (ex: IOException) {
        println("IO")
        println(ex.message)
    }
}

private fun reconnect() {
    cleanup()
    Thread.sleep(3000)
    try {
        connect()
        println("Connected!")
    } catch (ex: Exception) {
        println("Connect failed!")
        println(ex.message)
    }
}

