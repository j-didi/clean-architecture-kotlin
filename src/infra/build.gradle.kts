plugins {
    `java-library`
}

dependencies {
    implementation("org.ktorm:ktorm-core:3.4.1")
    implementation("io.insert-koin:koin-core:3.1.4")

    implementation(project(":core"))
}