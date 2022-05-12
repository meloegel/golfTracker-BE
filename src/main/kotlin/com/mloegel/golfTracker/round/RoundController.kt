package com.mloegel.golfTracker.round

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RoundController(val service: RoundService) {
    @GetMapping("/rounds")
    fun getAllRounds(): MutableIterable<Round> = service.findAllRounds()

}