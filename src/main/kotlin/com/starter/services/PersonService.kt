@file:Suppress("unused")

package com.starter.services

import com.starter.models.Person
import com.starter.models.ServiceResult
import com.starter.models.StatusCode
import com.starter.repositories.PersonRepository
import javax.inject.Inject
import javax.inject.Singleton

interface PersonService {
    fun getPersons(): ServiceResult<List<Person>>
    fun createPerson(person: Person): ServiceResult<Person>
}

@Singleton
class PersonServiceImp: PersonService {
    @Inject lateinit var personRepository: PersonRepository

    override fun getPersons() : ServiceResult<List<Person>> {
        val personList = personRepository.getPersons()
        return ServiceResult(StatusCode.OK, personList)
    }

    override fun createPerson(person: Person): ServiceResult<Person> {
        val createdPerson = personRepository.createPerson(person)
        return ServiceResult(StatusCode.CREATED, createdPerson)
    }
}