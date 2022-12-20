package com.si_base

import com.si_base.di.databaseModule
import com.si_base.di.repositoryModule
import com.si_base.di.routeModule
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.si_base.plugins.*
import io.ktor.server.locations.*
import org.koin.core.logger.Level
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun main() {
    embeddedServer(Netty, port = System.getenv("PORT").toInt(), module = Application::module)
        .start(wait = true)
}

@OptIn(KtorExperimentalLocationsAPI::class)
fun Application.module() {
    install(Koin) {
        slf4jLogger(Level.ERROR)
        modules(listOf(databaseModule, repositoryModule, routeModule))
    }
    configureSerialization()
    configureRouting()
}
