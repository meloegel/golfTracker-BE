package com.mloegel.golfTracker.round

import com.mloegel.golfTracker.user.UserService
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.*

@RestController
class RoundController(val service: RoundService, val userService: UserService) {

    @GetMapping("/rounds")
    fun getAllRounds(): MutableIterable<Round> = service.findAllRounds()

    @GetMapping("/rounds/round/{roundid}")
    fun getRoundByRoundid(@PathVariable roundid: Int): Round {
        try {
            return service.findRoundById(roundid)
        } catch (exception: EmptyResultDataAccessException) {
            throw Exception("Round with id $roundid not found! Exception: $exception")
        }
    }

    @GetMapping("/rounds/courseName/{courseName}")
    fun getRoundsByCourseName(@PathVariable courseName: String): List<Round> {
        try {
            return service.findRoundsByCourseName(courseName)
        } catch (exception: EmptyResultDataAccessException) {
            throw Exception("Course with name $courseName not found! Exception: $exception")
        }
    }

    @GetMapping("/rounds/user/{userid}")
    fun getRoundsByUser(@PathVariable userId: Int): List<Round> {
        try {
            val user = userService.findByUserid(userId)
            return service.findRoundsByUser(user)
        } catch (exception: EmptyResultDataAccessException) {
            throw Exception("User with user id $userId not found! Exception: $exception")
        }
    }


    @GetMapping("/rounds/search/courseName/{courseName}")
    fun searchForRoundsByCourseName(@PathVariable courseName: String): List<Round> {
        return service.searchRoundsByCourseName(courseName)
    }

    @PostMapping("/round/{userid}")
    fun postRound(@RequestBody round: Round, @PathVariable userid: Int) {
        val user = userService.findByUserid(userid)
        return service.postRound(round, user)
    }

    @DeleteMapping("/round/{roundid}")
    fun deleteRound(@PathVariable roundid: Int) {
        try {
            val round = service.findRoundById(roundid)
            return service.deleteRound(round)
        } catch (exception: EmptyResultDataAccessException) {
            throw Exception("Round with id $roundid not found! Exception: $exception")
        }
    }

}