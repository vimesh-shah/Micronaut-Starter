package com.starter.endpoints

import com.starter.models.Person
import com.starter.services.PersonService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import javax.inject.Inject

@Controller("/person")
class PersonController{

    @Inject lateinit var personService: PersonService

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    fun getPersons(): HttpResponse<List<Person>>{
        val result = personService.getPersons()
        return result.createResponse()
    }

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun createPerson(@Body person:Person): HttpResponse<Person>{
        val result = personService.createPerson(person)
        return result.createResponse()
    }
}