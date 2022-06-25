package com.starter.models

import io.micronaut.http.HttpResponse

class ServiceResult<T>{
    var status: StatusCode?= null
    var data: T? = null

    @Suppress("unused")
    constructor(status: StatusCode)
    {
        this.status = status
    }

    constructor(status: StatusCode, data: T)
    {
        this.status = status
        this.data = data
    }

    fun createResponse(): HttpResponse<T> {
        when(status){
            StatusCode.OK -> {
                if(data == null)
                {
                    return HttpResponse.ok()
                }

                return HttpResponse.ok(data)
            }
            StatusCode.CREATED -> {return HttpResponse.created(data)}
            StatusCode.NO_DATA -> return HttpResponse.noContent()
            StatusCode.NOT_FOUND -> return HttpResponse.notFound()
            StatusCode.BAD_REQUEST -> return HttpResponse.badRequest(data)
            StatusCode.SERVER_ERROR -> return HttpResponse.serverError(data)
            else -> return HttpResponse.serverError()
        }
    }
}

enum class StatusCode{
    OK,
    NO_DATA,
    CREATED,
    NOT_FOUND,
    BAD_REQUEST,
    SERVER_ERROR
}