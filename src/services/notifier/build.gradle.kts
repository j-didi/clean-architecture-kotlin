plugins {
    application
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

version = "1.5"

dependencies {
    implementation("com.rabbitmq:amqp-client:5.9.0")
}

application {
    mainClass.set("MainKt")
}