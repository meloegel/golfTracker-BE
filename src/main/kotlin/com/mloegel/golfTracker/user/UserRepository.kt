package com.mloegel.golfTracker.user

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, String> {
    fun findUserByUserid(userid: Int): User

    fun findByUsername(username: String): User

    fun findByUsernameContainingIgnoreCase(username: String): List<User>
}