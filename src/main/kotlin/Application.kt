package com.tidoo

import com.tidoo.model.DatabaseTaskRepository
import com.tidoo.model.Task
import com.tidoo.model.UserRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
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

//    configureSerialization(repository)
//    configureDatabases()
    configureRouting()
    println("DMONGO_URI=${System.getenv("DMONGO_URI")}")

    val repo = UserRepository()

    routing {
        get("/users") {
            call.respond(repo.all())
        }
        post("/users") {
            val user = call.receive<Task>()
            repo.add(user)
            call.respondText("User created", status = HttpStatusCode.Created)
        }
    }

}
