package com.starter.models

import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonIgnore
import io.micronaut.core.annotation.Introspected
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Introspected
data class Person(
    @BsonId
    @JsonIgnore
    var id: ObjectId?,
    var firstName: String?,
    var lastName: String?,
    var age: Int?,
    var mobile: String?
)
{
    @Suppress("unused")
    constructor():this(null, null, null, null, null)

    @Suppress("unused")
    @JsonGetter()
    fun getObjectId(): String{
        return id.toString()
    }
}