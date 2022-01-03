package plugins

import di.dependencies
import org.koin.core.context.startKoin

fun configureDependencies() {
    startKoin {
        modules(dependencies)
    }
}
