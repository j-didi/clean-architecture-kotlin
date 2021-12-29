import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"
}

subprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")

    group = "org.example"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation(kotlin("stdlib"))
    }

    kotlin {
        sourceSets {
            named("main") {
                kotlin.srcDir("kotlin")
            }
        }
    }

    sourceSets {
        named("main") {
            resources.srcDir("resources")
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }
}




