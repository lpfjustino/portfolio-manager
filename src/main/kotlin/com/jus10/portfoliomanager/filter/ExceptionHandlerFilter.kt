package com.jus10.portfoliomanager.filter

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import exception.DBException
import exception.ResourceAlreadyExistsException
import org.springframework.data.relational.core.conversion.DbActionExecutionException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import java.sql.SQLException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class ExceptionHandlerFilter : OncePerRequestFilter() {
    val DEFAULT_ERROR_MESSAGE: String = "Something unexpected happened"

    @Throws(ServletException::class, IOException::class)
    public override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch(e: ResourceAlreadyExistsException) {
            response.status = HttpStatus.BAD_REQUEST.value()
            response.writer.write(e.message)
        }
        catch(e: Exception) {
            response.status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            response.writer.write(e.message ?: DEFAULT_ERROR_MESSAGE)
        }
    }
}