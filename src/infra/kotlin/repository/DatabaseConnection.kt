package repository

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction
import repository.todos.TodoSchema

object DatabaseConnection {

    val connection = {
        Database.connect(
            url = "jdbc:sqlserver://host.docker.internal:1433",
            driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            user = "sa",
            password = "hthw8u:@y+5]Dp3,"
        )

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(TodoSchema)
        }
    }
}