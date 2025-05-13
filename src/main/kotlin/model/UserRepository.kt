package com.tidoo.model

import com.mongodb.kotlin.client.coroutine.MongoCollection
import com.tidoo.db.mongo.MongoFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.withContext

class UserRepository {
    private val col: MongoCollection<Task> = MongoFactory.database.getCollection("tasks", Task::class.java)

    suspend fun all(): List<Task> = withContext(Dispatchers.IO) {
        col.find().toList()
    }

    suspend fun add(task: Task) = withContext(Dispatchers.IO) {
        col.insertOne(task)
    }
}