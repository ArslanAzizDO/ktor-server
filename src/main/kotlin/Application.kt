package com.tidoo

import com.tidoo.model.DatabaseTaskRepository
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val repository = DatabaseTaskRepository()

    configureSerialization(repository)
    configureDatabases()
    configureRouting()
    // test commit to test if H2 persists in render docker container or not
}
