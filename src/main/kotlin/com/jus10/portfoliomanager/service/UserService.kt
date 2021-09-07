package com.jus10.portfoliomanager.service

import com.jus10.portfoliomanager.model.api.UserDTO
import com.jus10.portfoliomanager.model.api.toUser
import com.jus10.portfoliomanager.model.toUserDTO
import com.jus10.portfoliomanager.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    lateinit var userRepository: UserRepository

    fun findAll(): List<UserDTO> = userRepository.findAll().map { it.toUserDTO() }

    fun save(user: UserDTO) {
        userRepository.save(user.toUser())
    }
}