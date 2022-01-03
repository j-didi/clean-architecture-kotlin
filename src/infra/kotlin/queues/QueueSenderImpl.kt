package queues

import com.rabbitmq.client.ConnectionFactory
import ports.QueueSender
import usecases.todos.Todo
import java.nio.charset.StandardCharsets

object RabbitMQSettings {
    const val PORT = 5672
}

class QueueSenderImpl : QueueSender {

    override fun send(todo: Todo) {
        val factory = ConnectionFactory()
        factory.host = "host.docker.internal"
        factory.username = "user1"
        factory.password = "pass1"
        factory.virtualHost = "didi"
        factory.port = RabbitMQSettings.PORT

        val connection = factory.newConnection()
        val channel = connection.createChannel()

        val payload = "TODO: ${todo.description} was marked as done!"
        channel.basicPublish(
            "",
            "todo",
            null,
            payload.toByteArray(StandardCharsets.UTF_8)
        )
        println(" [x] Sent '$payload'")
    }
}
