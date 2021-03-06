rootProject.name = "clean-arch-kotlin"
include(":core")
include(":packages")
include(":infra")
include(":api")
include(":notifier")

project(":core").projectDir = file("src/core")
project(":packages").projectDir = file("src/packages")
project(":infra").projectDir = file("src/infra")
project(":api").projectDir = file("src/services/api")
project(":notifier").projectDir = file("src/services/notifier")
