package com.jus10.portfoliomanager.exception

import org.springframework.http.HttpStatus

open class ApiRuntimeExceptions(override val message: String = "Something unexpected happened", open val code: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR) : RuntimeException()

data class ResourceAlreadyExistsException(override val message: String = "Resource already exists", override val code: HttpStatus = HttpStatus.CONFLICT) : ApiRuntimeExceptions()
data class DBException(override val message: String = "Something blew up on the DB", override val code: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR) : ApiRuntimeExceptions()
