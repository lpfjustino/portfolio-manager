package com.jus10.portfoliomanager.model

import com.jus10.portfoliomanager.model.api.UserDTO
import org.springframework.data.annotation.Id
import java.util.*

data class User(
    @Id val id: UUID?,
    val username: String,
)

fun User.toUserDTO() = UserDTO(
    username = username,
)
