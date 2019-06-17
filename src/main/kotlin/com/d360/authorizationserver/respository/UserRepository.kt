package com.d360.authorizationserver.respository

import com.d360.authorizationserver.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, String> {
    fun findByUserName(userName: String): User
}