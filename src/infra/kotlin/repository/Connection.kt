package repository

import org.ktorm.database.Database


internal object Connection {
    val database = Database.connect(
        url = "jdbc:sqlserver://localhost:1433;database=Todo",
        user = "sa",
        password = "hthw8u:@y+5]Dp3,"
    )
}