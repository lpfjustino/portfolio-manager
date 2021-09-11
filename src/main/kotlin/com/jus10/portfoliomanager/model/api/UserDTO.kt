package com.jus10.portfoliomanager.model.api

import com.jus10.portfoliomanager.model.User

data class UserDTO(
    val username: String,
)

fun UserDTO.toUser() = User(username)
