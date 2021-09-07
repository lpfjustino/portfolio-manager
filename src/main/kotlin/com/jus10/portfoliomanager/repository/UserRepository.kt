package com.jus10.portfoliomanager.repository

import com.jus10.portfoliomanager.model.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long>
