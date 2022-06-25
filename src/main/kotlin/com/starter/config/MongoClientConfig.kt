package com.starter.config

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.starter.models.Person
import io.micronaut.context.annotation.Value
import javax.inject.Singleton

@Singleton
class MongoClientConfig(private var mongoClient: MongoClient) {

    @Value("\${mongodb.dbname}")
    private lateinit var dbname: String

    fun <T: Any> getCollection(collectionName: String, type: Class<T>) : MongoCollection<T>{
        val db = mongoClient.getDatabase(dbname)
        return db.getCollection(collectionName, type)
    }

    fun getPersonCollection() : MongoCollection<Person>{
        return getCollection("person", Person::class.java)
    }
}