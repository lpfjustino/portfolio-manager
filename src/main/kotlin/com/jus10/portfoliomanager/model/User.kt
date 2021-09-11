package com.jus10.portfoliomanager.model

import com.jus10.portfoliomanager.model.api.UserDTO
import org.springframework.data.annotation.Id
import java.util.*

data class User(
    @Id val id: UUID,
    val username: String,
) {
    constructor(username: String) : this(UUID.randomUUID(), username)
}

fun User.toUserDTO() = UserDTO(username)
