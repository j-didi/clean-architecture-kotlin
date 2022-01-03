package plugins

import repository.DatabaseConnection

fun configureDatabase() {
    DatabaseConnection.connection()
}
