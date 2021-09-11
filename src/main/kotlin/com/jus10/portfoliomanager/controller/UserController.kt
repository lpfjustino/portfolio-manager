package com.jus10.portfoliomanager.controller

import com.jus10.portfoliomanager.model.api.UserDTO
import com.jus10.portfoliomanager.service.PerformanceService
import com.jus10.portfoliomanager.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    lateinit var userService: UserService
    @Autowired
    lateinit var performanceService: PerformanceService

    @GetMapping
    fun findAll() = userService.findAll()

    @PostMapping
    fun create(@RequestBody user: UserDTO) = userService.save(user)

    @GetMapping("/{userId}/performance")
    fun getPerformance(@PathVariable userId: UUID) = performanceService.getPerformance(userId)
}