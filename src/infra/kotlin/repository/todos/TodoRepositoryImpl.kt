package repository.todos

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import ports.TodoRepository
import repository.DatabaseConnection
import usecases.todos.Todo
import java.util.*

class TodoRepositoryImpl : TodoRepository {

    override fun get(): List<Todo> =
        transaction {
            DatabaseConnection.start()
            TodoSchema.selectAll()
                .map {
                    Todo(
                        id = it[TodoSchema.id],
                        description = it[TodoSchema.description],
                        done = it[TodoSchema.done]
                    )
                }
        }

    override fun getById(id: UUID): Todo? =
        transaction {
            TodoSchema
                .select { TodoSchema.id eq id }
                .map {
                    Todo(
                        id = it[TodoSchema.id],
                        description = it[TodoSchema.description],
                        done = it[TodoSchema.done]
                    )
                }.firstOrNull()
        }

    override fun save(todo: Todo) {
        transaction {
            TodoSchema.insert {
                it[id] = todo.id
                it[description] = todo.description
                it[done] = todo.done
            }
        }
    }

    override fun delete(todo: Todo) {
        transaction {
            TodoSchema.deleteWhere { TodoSchema.id eq todo.id }
        }
    }

    override fun markAsDone(todo: Todo) {
        transaction {
            TodoSchema.update({ TodoSchema.id eq todo.id }) {
                it[done] = true
            }
        }
    }
}