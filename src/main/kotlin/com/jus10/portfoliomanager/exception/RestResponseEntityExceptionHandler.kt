package com.jus10.portfoliomanager.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.sql.SQLException

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {
    companion object {
        const val UNIQUE_VIOLATION: String = "23505"
    }

    @ExceptionHandler(value = [(SQLException::class)])
    protected fun handleConflict(ex: SQLException, request: WebRequest): ResponseEntity<Any?> {
        val e: ApiRuntimeExceptions = when(ex.sqlState) {
            UNIQUE_VIOLATION -> ResourceAlreadyExistsException()
            else -> DBException()
        }
        return handleExceptionInternal(e, e.message, HttpHeaders(), e.code, request)
    }
}