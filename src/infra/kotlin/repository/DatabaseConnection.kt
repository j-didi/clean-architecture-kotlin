package repository

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseConnection {

    fun start() {

        Database.connect(
            url = "jdbc:sqlserver://localhost:1433;databaseName=Todo",
            driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            user = "sa",
            password = "hthw8u:@y+5]Dp3,"
        )

        transaction {
            addLogger(StdOutSqlLogger)
        }
    }

}