package repository.todos

import org.ktorm.database.Database
import org.ktorm.entity.Entity
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.boolean
import org.ktorm.schema.uuid
import org.ktorm.schema.varchar
import java.util.*

internal interface TodoEntity : Entity<TodoEntity> {
    companion object : Entity.Factory<TodoEntity>()

    var id: UUID
    var description: String
    var done: Boolean
}

internal object Todos : Table<TodoEntity>("todo") {

    val id = uuid("id").primaryKey().bindTo { it.id }
    val description = varchar("description").bindTo { it.description }
    val done = boolean("done").bindTo { it.done }
}

internal val Database.todos get() = this.sequenceOf(Todos)