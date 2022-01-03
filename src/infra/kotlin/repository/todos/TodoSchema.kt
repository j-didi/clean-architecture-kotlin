package repository.todos

import common.DescriptionRules
import org.jetbrains.exposed.sql.Table

object TodoSchema : Table("TODO") {
    val id = uuid("id")
    val description = varchar("description", DescriptionRules.MAX_LENGTH)
    val done = bool("done")

    override val primaryKey = PrimaryKey(id)
}
