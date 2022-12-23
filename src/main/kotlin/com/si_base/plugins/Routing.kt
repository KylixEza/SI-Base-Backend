package com.si_base.plugins

import com.si_base.route.SIBaseRoute
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.locations.*
import io.ktor.server.application.*
import io.ktor.server.response.*

import org.koin.ktor.ext.inject

@KtorExperimentalLocationsAPI
fun Application.configureRouting() {

    val route by inject<SIBaseRoute>()

    install(Locations) {
    }

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        route.apply { this@routing.initRoutes() }
    }
}
