package com.tidoo.model

import com.mongodb.kotlin.client.coroutine.MongoCollection
import com.tidoo.db.mongo.MongoFactory
import kotlinx.coroutines.flow.toList

class UserRepository {
    private val col: MongoCollection<Task> = MongoFactory.database.getCollection("users")

    suspend fun all(): List<Task> =
        col.find().toList()

    suspend fun add(user: Task) =
        col.insertOne(user)
}