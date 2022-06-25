@file:Suppress("unused")

package com.starter.repositories

import com.starter.config.MongoClientConfig
import com.starter.models.Person
import javax.inject.Inject
import javax.inject.Singleton

interface PersonRepository {
    fun getPersons() : List<Person>
    fun createPerson(person: Person) : Person
}

@Singleton
class PersonRepositoryImpl: PersonRepository{

    @Inject lateinit var mongoClient: MongoClientConfig

    override fun getPersons(): List<Person> {
        val collection = mongoClient.getPersonCollection()
        return collection.find().toList()
    }

    override fun createPerson(person: Person): Person {
        val collection = mongoClient.getPersonCollection()
        collection.insertOne(person)
        return person
    }
}