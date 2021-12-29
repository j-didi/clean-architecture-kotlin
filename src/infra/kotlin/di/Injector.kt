package di

import org.koin.dsl.module
import ports.TodoRepository
import repository.Connection
import repository.todos.TodoRepositoryImpl
import usecases.todos.create.CreateTodoHandler
import usecases.todos.create.CreateTodoHandlerImpl
import usecases.todos.create.CreateTodoValidator

val dependencies = module {
    factory<CreateTodoHandler> { CreateTodoHandlerImpl(get(), get()) }
    factory { CreateTodoValidator() }
    factory<TodoRepository> { TodoRepositoryImpl(Connection.database) }
}