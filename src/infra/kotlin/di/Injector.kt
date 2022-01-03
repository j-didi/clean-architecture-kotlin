package di

import org.koin.dsl.module
import ports.QueueSender
import ports.TodoRepository
import queues.QueueSenderImpl
import repository.todos.TodoRepositoryImpl
import usecases.todos.create.CreateTodoHandler
import usecases.todos.create.CreateTodoHandlerImpl
import usecases.todos.create.CreateTodoValidator
import usecases.todos.delete.DeleteTodoHandler
import usecases.todos.delete.DeleteTodoHandlerImpl
import usecases.todos.get.GetTodosHandler
import usecases.todos.get.GetTodosHandlerImpl
import usecases.todos.getbyid.GetTodoByIdHandler
import usecases.todos.getbyid.GetTodoByIdHandlerImpl
import usecases.todos.markasdone.MarkTodoAsDoneHandler
import usecases.todos.markasdone.MarkTodoAsDoneHandlerImpl

val dependencies = module {
    factory<GetTodosHandler> { GetTodosHandlerImpl(get()) }
    factory<GetTodoByIdHandler> { GetTodoByIdHandlerImpl(get()) }
    factory<CreateTodoHandler> { CreateTodoHandlerImpl(get(), get()) }
    factory<MarkTodoAsDoneHandler> { MarkTodoAsDoneHandlerImpl(get(), get()) }
    factory<DeleteTodoHandler> { DeleteTodoHandlerImpl(get()) }
    factory { CreateTodoValidator() }
    factory<TodoRepository> { TodoRepositoryImpl() }
    factory<QueueSender> { QueueSenderImpl() }
}
