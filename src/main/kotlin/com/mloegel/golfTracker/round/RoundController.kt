package com.mloegel.golfTracker.round

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class RoundController(val service: RoundService) {
    @GetMapping("/rounds")
    fun getAllRounds(): MutableIterable<Round> = service.findAllRounds()

    @GetMapping("/rounds/round/{roundid}")
    fun getRoundByRoundid(@PathVariable roundid: Int): Round {
        try {
            return service.findRoundById(roundid)
        }catch (exception: EmptyResultDataAccessException) {
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

    @GetMapping("rounds/search/courseName/{courseName}")
    fun searchForRoundsByCourseName(@PathVariable courseName: String): List<Round> {
        return service.searchRoundsByCourseName(courseName)
    }

}