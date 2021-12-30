plugins {
    `java-library`
}

dependencies {
    implementation("io.insert-koin:koin-core:3.1.4")

    implementation("org.jetbrains.exposed:exposed-core:0.37.3")
    implementation("org.jetbrains.exposed:exposed-dao:0.37.3")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.37.3")
    implementation("com.microsoft.sqlserver:mssql-jdbc:9.4.1.jre16")

    implementation(project(":core"))
}