package com.mloegel.golfTracker.user

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val service: UserService) {
    @GetMapping("/users")
    fun getAllUsers(): MutableIterable<User> = service.findAllUsers()

    @GetMapping("/users/user/{userid}")
    fun getUserByUserid(@PathVariable userid: Int): User {
        try {
            return service.findByUserid(userid)
        } catch (exception: EmptyResultDataAccessException) {
            throw Exception("User with id $userid not found! Exception: $exception")
        }
    }

    @GetMapping("/users/user/{username}")
    fun getUserByUsername(@PathVariable username: String): User {
        try {
            return service.findByUsername(username)
        } catch (exception: EmptyResultDataAccessException) {
            throw Exception("User with username $username not found! Exception: $exception")
        }
    }

    @PostMapping("/user")
    fun postUser(@RequestBody user: User) = service.postUser(user)

    @GetMapping("/users/username/{username}")
    fun searchByUsername(@PathVariable username: String): List<User> {
        return service.searchByUsername(username)
    }

@DeleteMapping("/user/{userid}")
fun deleteUser(@PathVariable userid: Int) {
    try {
        val user = service.findByUserid(userid)
        return service.deleteUser(user)
    } catch (exception: EmptyResultDataAccessException) {
        throw Exception("User with userid $userid not found! Exception: $exception")
    }
}

}