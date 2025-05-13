package com.tidoo

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.tidoo.db.mongo.MongoFactory
import com.tidoo.model.Task
import com.tidoo.model.UserRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.bson.Document

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
        }
    }
    val repo = UserRepository()
    routing {
        get("/users") {
            print("users response = ${repo.all()}")
            call.respond(repo.all())
        }
        post("/users") {
            val user = call.receive<Task>()
            repo.add(user)
            call.respondText("User created", status = HttpStatusCode.Created)
        }
        get("/") {
            call.respondText("Hello World!")
        }

        get("/gugu") {
            call.respondText("gaga")
        }

        get("/bye"){
            call.respondText(text = "500: bye" , status = HttpStatusCode.InternalServerError)
        }

        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
