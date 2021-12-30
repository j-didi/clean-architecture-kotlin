val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    application
}

repositories {
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-serialization-gson:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("io.insert-koin:koin-core:3.1.4")

    implementation(project(":core"))
    implementation(project(":infra"))
    implementation(project(":packages"))
}