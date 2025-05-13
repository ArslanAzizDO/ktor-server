package com.tidoo

import com.tidoo.model.DatabaseTaskRepository
import com.tidoo.model.Task
import com.tidoo.model.UserRepository
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
//    val repository = DatabaseTaskRepository()
    install(ContentNegotiation) {
        json() // kotlinx.serialization or Gson/Jackson depending on what you're using
    }
//    configureSerialization(repository)
//    configureDatabases()
    configureRouting()


}
