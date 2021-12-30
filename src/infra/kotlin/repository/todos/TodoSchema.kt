package repository.todos

import org.jetbrains.exposed.sql.Table

object TodoSchema : Table("TODO") {
    val id = uuid("id")
    val description = varchar("description", 250)
    val done = bool("done")

    override val primaryKey = PrimaryKey(id)
}
