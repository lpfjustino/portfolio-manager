package com.jus10.portfoliomanager.model.api

import com.jus10.portfoliomanager.model.User
import java.util.*

data class UserDTO(
    val id: UUID,
    val username: String,
)

fun UserDTO.toUser() = User(username)
