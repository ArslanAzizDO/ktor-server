package com.tidoo.db.mongo

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase

object MongoFactory {
    //    private val uri: String = System.getenv("MONGODB_URI") ?: error("Missing MONGODB_URI env var")
    val client: MongoClient = MongoClient.Factory.create(
        System.getenv("DMONGO_URI") ?: error("No URI")
    )
    val database: MongoDatabase = client.getDatabase(System.getenv("DMONGO_DATABASE") ?: error("No URI"))
}