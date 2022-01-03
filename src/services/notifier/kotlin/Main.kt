import com.rabbitmq.client.ConnectionFactory
import com.rabbitmq.client.Connection
import com.rabbitmq.client.Channel
import com.rabbitmq.client.DeliverCallback
import com.rabbitmq.client.Delivery
import com.rabbitmq.client.CancelCallback
import com.rabbitmq.client.ShutdownSignalException
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeoutException

private const val QUEUE: String = "todo"
private const val TAG = "Notifier"
private const val PORT = 5672
private const val NETWORK_INTERVAL = 5000L
private const val REQUEST_HEART_BEAT = 30
private const val THREAD_SLEEP_TIME = 3000L
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
    factory.port = PORT
    factory.networkRecoveryInterval = NETWORK_INTERVAL
    factory.requestedHeartbeat = REQUEST_HEART_BEAT

    try {
        connection = factory.newConnection()
        connection.addShutdownListener(shutdownListener())

        channel = connection.createChannel()
        channel.queueDeclare(QUEUE, false, false, false, null)

        val deliverCallback = DeliverCallback { _: String?, delivery: Delivery ->
            val message = String(
                bytes = delivery.body,
                charset = StandardCharsets.UTF_8
            )
            println("[$TAG] Received message: '$message'")
        }
        val cancelCallback = CancelCallback { println("[$it] was canceled") }
        channel.basicConsume(QUEUE, true, TAG, deliverCallback, cancelCallback)
    } catch (ex: TimeoutException) {
        println(ex.message)
        Thread.sleep(THREAD_SLEEP_TIME)
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
    Thread.sleep(THREAD_SLEEP_TIME)
    try {
        connect()
        println("Connected!")
    } catch (ex: TimeoutException) {
        println("Connect failed!")
        println(ex.message)
    }
}

