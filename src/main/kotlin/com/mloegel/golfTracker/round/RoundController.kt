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



}